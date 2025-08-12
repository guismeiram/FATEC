<!-- Spring Security - Autenticação e Autorização -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>

<!-- Biblioteca JWT (JSON Web Tokens) -->
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-api</artifactId>
    <version>0.11.5</version>
</dependency>

_________________________________________________________________

// src/main/java/com/example/projeto/config/SecurityConfig.java

@Configuration
@EnableWebSecurity // Habilita segurança web
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // Desabilita CSRF para APIs stateless
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/auth/**").permitAll() // Rotas públicas
                .requestMatchers("/admin/**").hasRole("ADMIN") // Acesso restrito
                .anyRequest().authenticated() // Demais rotas exigem autenticação
            )
            .addFilterBefore(jwtAuthFilter(), UsernamePasswordAuthenticationFilter.class); // Filtro JWT
        return http.build();
    }
}

_________________________________________________________________

// src/main/java/com/example/projeto/auth/JwtService.java

@Service
public class JwtService {
    private final String SECRET_KEY = "mySecretKey123!"; // Chave secreta (deveria estar em config)

    public String generateToken(UserDetails user) {
        return Jwts.builder()
            .setSubject(user.getUsername()) // Identificação do usuário
            .setIssuedAt(new Date()) // Data de emissão
            .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // Expira em 1h
            .signWith(SignatureAlgorithm.HS256, SECRET_KEY) // Algoritmo de assinatura
            .compact(); // Gera o token string
    }
}
_________________________________________________________________


public class JwtAuthFilter extends OncePerRequestFilter {
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, 
                                  HttpServletResponse response, 
                                  FilterChain chain) throws IOException, ServletException {
        
        String token = extractToken(request); // Extrai do header Authorization
        if (token != null && jwtService.validateToken(token)) {
            // Cria objeto Authentication e configura no SecurityContext
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                jwtService.extractUsername(token), null, jwtService.extractRoles(token));
            SecurityContextHolder.getContext().setAuthentication(auth);
        }
        chain.doFilter(request, response); // Continua o fluxo da requisição
    }
}
_________________________________________________________________

POST /auth/login HTTP/1.1
Content-Type: application/json

{
    "username": "admin",
    "password": "123456"
}

_________________________________________________________________

GET /api/produtos HTTP/1.1
Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...

_________________________________________________________________


public TokenResponse refreshToken(String refreshToken) {
    if (jwtService.validateToken(refreshToken)) {
        String username = jwtService.extractUsername(refreshToken);
        UserDetails user = userService.loadUserByUsername(username);
        return new TokenResponse(jwtService.generateToken(user)); // Novo access token
    }
    throw new InvalidTokenException(); // Se token inválido
}
_________________________________________________________________


