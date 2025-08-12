// src/main/java/com/example/projeto/web/ProdutoController.java

@Controller                     // Define como Controller Spring MVC
@RequestMapping("/produtos")    // Mapeia requisições para /produtos
@RequiredArgsConstructor        // Gera construtor com dependências (Lombok)
public class ProdutoController {
    private final ProdutoService service;  // Injeção de dependência

    @GetMapping                 // Mapeia requisições GET /produtos
    public String listar(Model model) {    // Model para passar dados à view
        model.addAttribute("produtos", service.listarTodos());  // Adiciona lista de produtos
        return "produtos/lista"; // Retorna o template Thymeleaf
    }
}

________________________________________________________________________

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org"> <!-- Namespace Thymeleaf -->
<head>
    <title>Lista de Produtos</title>
</head>
<body>
    <h1>Produtos</h1>
    <table>
        <tr th:each="produto : ${produtos}"> <!-- Loop na lista -->
            <td th:text="${produto.nome}"></td> <!-- Exibe nome -->
            <td th:text="${#numbers.formatCurrency(produto.preco)}"></td> <!-- Formata preço -->
        </tr>
    </table>
</body>
</html>

________________________________________________________________________

// src/main/java/com/example/projeto/integration/CepService.java

@Service
public class CepService {
    private final RestTemplate restTemplate;  // Cliente HTTP Spring

    public Endereco buscarPorCep(String cep) {
        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        return restTemplate.getForObject(url, Endereco.class);  
		// Desserializa JSON automaticamente
    }
}

________________________________________________________________________

@ControllerAdvice  // Habilita tratamento global de exceções
public class WebExceptionHandler {
    @ExceptionHandler(RestClientException.class)  // Captura erros de API
    public String handleApiError(Model model) {
        model.addAttribute("error", "Falha ao consultar API externa");
        return "error";  // Template de erro genérico
    }
}

________________________________________________________________________

@PostMapping("/cadastrar")
public String cadastrar(@Valid ProdutoForm form, BindingResult result) {  // Validação automática
    if (result.hasErrors()) {  // Verifica erros de validação
        return "produtos/form";  // Reexibe o formulário
    }
    service.cadastrar(form.toEntity());  // Conversão para entidade
    return "redirect:/produtos";  // PRG Pattern
}


________________________________________________________________________


<form th:action="@{/produtos/cadastrar}" th:object="${form}" method="post">
    <input th:field="*{nome}" type="text">  <!-- Binding automático -->
    <p th:if="${#fields.hasErrors('nome')}" th:errors="*{nome}"></p>  <!-- Exibe erro -->
    
    <input th:field="*{preco}" type="number" step="0.01">  <!-- Input numérico -->
    <button type="submit">Salvar</button>
</form>

________________________________________________________________________


// Em lista.html
fetch('/api/produtos')  // Endpoint REST
  .then(response => response.json())  // Converte resposta
  .then(data => {
      // Atualiza tabela dinamicamente (exemplo SPA)
  });