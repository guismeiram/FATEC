<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-api</artifactId>
    <version>0.11.5</version>
</dependency>


________________________________________________________________

@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class SecurityConfig {
    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return http
            .csrf().disable()
            .authorizeExchange()
                .pathMatchers("/auth/**").permitAll()
                .anyExchange().authenticated()
            .and()
            .addFilterAt(jwtAuthFilter(), SecurityWebFiltersOrder.AUTHENTICATION)
            .build();
    }
}

________________________________________________________________

public class JwtAuthFilter implements WebFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        String token = extractToken(exchange.getRequest());
        if (token == null) return chain.filter(exchange);

        return Mono.just(token)
            .flatMap(jwtUtil::validateToken)
            .flatMap(auth -> chain.filter(exchange)
                .contextWrite(ReactiveSecurityContextHolder.withAuthentication(auth)));
    }
}

________________________________________________________________


@Service
@RequiredArgsConstructor
public class AuthService {
    private final ReactiveUserDetailsService userDetailsService;
    private final PasswordEncoder encoder;

    public Mono<Authentication> authenticate(String username, String password) {
        return userDetailsService.findByUsername(username)
            .filter(user -> encoder.matches(password, user.getPassword()))
            .map(user -> new UsernamePasswordAuthenticationToken(
                user, null, user.getAuthorities()
            ));
    }
}

________________________________________________________________

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final JwtUtil jwtUtil;

    @PostMapping("/login")
    public Mono<String> login(@RequestBody AuthRequest request) {
        return authService.authenticate(request.username(), request.password())
            .flatMap(jwtUtil::generateToken);
    }
}

________________________________________________________________

public record AuthRequest(String username, String password) {}

________________________________________________________________

