<!-- Dependências Maven para segurança Spring Boot e JWT -->
<dependency>  
  <groupId>org.springframework.boot</groupId>  
  <artifactId>spring-boot-starter-security</artifactId>  <!-- Habilita segurança no Spring -->
</dependency>  
<dependency>  
  <groupId>io.jsonwebtoken</groupId>  
  <artifactId>jjwt-api</artifactId>  <!-- Biblioteca para trabalhar com JWT -->
  <version>0.11.5</version>  
</dependency>  

______________________________________________________________

// Configuração de segurança do Spring
@EnableWebSecurity  // Habilita segurança web
public class SecurityConfig extends WebSecurityConfigurerAdapter {  
  @Override  
  protected void configure(HttpSecurity http) throws Exception {  
    http  
      .cors().and().csrf().disable()  // Desabilita CSRF e configura CORS
      .authorizeRequests()  
        .antMatchers("/api/auth/**").permitAll()  // Libera endpoints de autenticação
        .anyRequest().authenticated()  // Todos outros endpoints requerem autenticação
      .and()  
      .addFilter(new JwtAuthenticationFilter(authenticationManager()))  // Filtro para login
      .addFilter(new JwtAuthorizationFilter(authenticationManager())); // Filtro para validação JWT
  }  
}

______________________________________________________________

// Serviço Angular para autenticação
@Injectable({ providedIn: 'root' })  
export class AuthService {  
  private apiUrl = 'http://localhost:8080/api/auth';  // URL do backend

  constructor(private http: HttpClient) {}  

  // Método para login
  login(credentials: { username: string; password: string }) {  
    return this.http.post<{ token: string }>(`${this.apiUrl}/login`, credentials);  
  }  

  // Método para registro de usuário
  register(user: { username: string; password: string }) {  
    return this.http.post(`${this.apiUrl}/register`, user);  
  }  
}

______________________________________________________________

// Interceptor para adicionar token JWT às requisições
@Injectable()  
export class JwtInterceptor implements HttpInterceptor {  
  intercept(req: HttpRequest<any>, next: HttpHandler) {  
    const token = localStorage.getItem('token');  // Obtém token do localStorage
    if (token) {  
      req = req.clone({  
        setHeaders: { Authorization: `Bearer ${token}` }  // Adiciona token no header
      });  
    }  
    return next.handle(req);  // Continua a cadeia de interceptors
  }  
}

______________________________________________________________

// Configuração do provider do interceptor
providers: [  
  { 
    provide: HTTP_INTERCEPTORS, 
    useClass: JwtInterceptor,  // Registra o interceptor
    multi: true  // Permite múltiplos interceptors
  }  
]

______________________________________________________________

// Componente de login
export class LoginComponent {  
  credentials = { username: '', password: '' };  // Modelo para formulário

  constructor(
    private authService: AuthService, 
    private router: Router
  ) {}  

  // Método chamado ao submeter o formulário
  onSubmit() {  
    this.authService.login(this.credentials).subscribe(res => {  
      localStorage.setItem('token', res.token);  // Armazena token
      this.router.navigate(['/tasks']);  // Redireciona para tarefas
    });  
  }  
}

______________________________________________________________

<!-- Template do componente de login -->
<form (ngSubmit)="onSubmit()">  
  <input [(ngModel)]="credentials.username" placeholder="Usuário">  <!-- Two-way binding -->
  <input type="password" [(ngModel)]="credentials.password" placeholder="Senha">  
  <button type="submit">Entrar</button>  
</form> 

______________________________________________________________


// Guarda de rota para proteção
@Injectable({ providedIn: 'root' })  
export class AuthGuard implements CanActivate {  
  constructor(private router: Router) {}  

  // Método que verifica se usuário está autenticado
  canActivate(): boolean {  
    if (!localStorage.getItem('token')) {  
      this.router.navigate(['/login']);  // Redireciona se não autenticado
      return false;  
    }  
    return true;  // Permite acesso se autenticado
  }  
}

______________________________________________________________

// Aplicando guarda de rota
{ 
  path: 'tasks', 
  component: TaskListComponent, 
  canActivate: [AuthGuard]  // Protege a rota com AuthGuard
}
______________________________________________________________

/* Fluxo completo de autenticação:
1. Login → Gera token JWT no backend
2. Token → Armazenado no localStorage
3. Requests → Autenticadas com token no header
4. AuthGuard → Protege rotas verificando token
*/