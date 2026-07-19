// @RestController indica que esta classe é um controlador REST
// que retorna diretamente os dados no corpo da resposta HTTP
@RestController
// @RequestMapping define o prefixo comum para todas as rotas deste controlador
@RequestMapping("/api")
public class HelloController {

    // @GetMapping mapeia requisições HTTP GET para o método sayHello()
    @GetMapping("/hello")
    public String sayHello() {
        // Retorna uma string simples como resposta
        return "Hello from Spring Boot!";
    }
}

____________________________________________________________________________________

# Cria um novo projeto Angular chamado 'hello-frontend'
ng new hello-frontend

# Entra na pasta do projeto recém-criado
cd hello-frontend

____________________________________________________________________________________

// Importa o HttpClient para fazer requisições HTTP
import { HttpClient } from '@angular/common/http';

// Decorator @Component (implícito no arquivo .ts do componente)
export class AppComponent {
  // Propriedade para armazenar a mensagem recebida do backend
  message: string = '';

  // Injeção de dependência do HttpClient
  constructor(private http: HttpClient) {
    // Faz uma requisição GET para o endpoint do Spring Boot
    this.http.get('http://localhost:8080/api/hello').subscribe((res: any) => {
      // Atualiza a propriedade message com a resposta do servidor
      this.message = res;
    });
  }
}
____________________________________________________________________________________

<!-- Exibe a mensagem recebida do backend usando interpolação do Angular -->
<!-- A sintaxe {{ message }} mostra o valor da propriedade message do componente -->
<h1>{{ message }}</h1>

____________________________________________________________________________________

