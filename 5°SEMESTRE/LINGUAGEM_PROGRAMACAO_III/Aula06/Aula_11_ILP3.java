<!-- Dependências Maven para segurança Spring Boot e JWT -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>  <!-- Habilita segurança no Spring Boot -->
</dependency>
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-api</artifactId>  <!-- Biblioteca para trabalhar com JWT -->
    <version>0.11.5</version>
</dependency>

_________________________________________________________________

// Configuração principal de segurança
@EnableWebSecurity  // Habilita a segurança web do Spring
public class SecurityConfig {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()  // Desabilita CSRF para APIs stateless
            .authorizeRequests()
                .antMatchers("/api/auth/**").permitAll()  // Permite acesso sem autenticação
                .anyRequest().authenticated()  // Todas outras rotas requerem autenticação
            .and()
            .addFilter(new JwtAuthFilter(authenticationManager()))  // Adiciona filtro JWT
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);  // API stateless
        return http.build();
    }
}

_________________________________________________________________

// Classe utilitária para operações com JWT
public class JwtUtil {
    private static final String SECRET_KEY = "chave-secreta-super-forte-123456";  // Chave secreta para assinar tokens
    private static final long EXPIRATION_TIME = 86400000; // 1 dia em milissegundos

    // Método para gerar token JWT
    public String generateToken(String username) {
        return Jwts.builder()
            .setSubject(username)  // Define o subject (normalmente username)
            .setIssuedAt(new Date())  // Data de criação
            .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))  // Data de expiração
            .signWith(SignatureAlgorithm.HS256, SECRET_KEY)  // Algoritmo de assinatura
            .compact();  // Gera o token compacto
    }
}

_________________________________________________________________

// Controller para autenticação
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private JwtUtil jwtUtil;  // Injeta o utilitário JWT

    // Endpoint de login
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        // Validação simplificada (em produção, usar UserDetailsService)
        if ("admin".equals(request.username()) && "123".equals(request.password())) {
            String token = jwtUtil.generateToken(request.username());  // Gera token
            return ResponseEntity.ok(token);  // Retorna token
        }
        return ResponseEntity.status(401).build();  // Credenciais inválidas
    }
}
_________________________________________________________________

// Serviço Angular para autenticação
@Injectable({ providedIn: 'root' })
export class AuthService {
    private apiUrl = 'http://localhost:8080/api/auth';  // URL do backend

    constructor(private http: HttpClient) {}

    // Método para realizar login
    login(credentials: { username: string; password: string }) {
        return this.http.post<{ token: string }>(`${this.apiUrl}/login`, credentials);
    }
}

_________________________________________________________________

// Componente de login Angular
export class LoginComponent {
    credentials = { username: '', password: '' };  // Modelo para o formulário

    constructor(
        private authService: AuthService,  // Serviço de autenticação
        private router: Router  // Para navegação
    ) {}

    // Método chamado ao submeter o formulário
    onSubmit() {
        this.authService.login(this.credentials).subscribe({
            next: (res) => {
                localStorage.setItem('token', res.token);  // Armazena token
                this.router.navigate(['/']);  // Redireciona para home
            },
            error: (err) => alert('Login falhou!')  // Tratamento de erro
        });
    }
}

_________________________________________________________________

// Interceptor para adicionar token às requisições
@Injectable()
export class JwtInterceptor implements HttpInterceptor {
    intercept(req: HttpRequest<any>, next: HttpHandler) {
        const token = localStorage.getItem('token');  // Obtém token do localStorage
        if (token) {
            // Clona a requisição adicionando o header Authorization
            req = req.clone({
                setHeaders: { Authorization: `Bearer ${token}` }
            });
        }
        return next.handle(req);  // Continua a cadeia de interceptors
    }
}

_________________________________________________________________

// Guarda de rota para proteger rotas autenticadas
@Injectable({ providedIn: 'root' })
export class AuthGuard implements CanActivate {
    constructor(private router: Router) {}

    canActivate(): boolean {
        if (!localStorage.getItem('token')) {  // Verifica se existe token
            this.router.navigate(['/login']);  // Redireciona para login
            return false;  // Bloqueia acesso
        }
        return true;  // Permite acesso
    }
}

_________________________________________________________________

// Configuração de rotas com proteção
const routes: Routes = [
    { path: 'login', component: LoginComponent },  // Rota pública
    { path: '', component: HomeComponent, canActivate: [AuthGuard] }  // Rota protegida
];
_________________________________________________________________

