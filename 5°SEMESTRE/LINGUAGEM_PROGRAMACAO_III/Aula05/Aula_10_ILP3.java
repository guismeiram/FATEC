// Endpoint para criação de produto com tratamento genérico de resposta
@PostMapping
public ResponseEntity<?> create(@Valid @RequestBody ProductDTO dto) {
    // ResponseEntity<?> permite retornar diferentes tipos de resposta
    // @Valid ativa as validações definidas no DTO
    // @RequestBody indica que o payload JSON será convertido para o DTO
    // Lógica de criação seria implementada aqui
}

__________________________________________________________________________

// Record para padronizar respostas de erro
public record ErrorResponse(
    String message,          // Mensagem descritiva do erro
    LocalDateTime timestamp  // Data/hora em que o erro ocorreu
) {
    // Records são imutáveis e geram automaticamente:
    // - Construtor
    // - Getters
    // - equals(), hashCode() e toString()
}
__________________________________________________________________________

// DTO (Data Transfer Object) para validação de entrada
public record ProductRequestDTO(
    @NotBlank(message = "Nome é obrigatório")  // Valida se não é nulo/vazio
    @Size(min = 3, max = 100, message = "Nome deve ter 3-100 caracteres")  // Valida tamanho
    String name,  // Nome do produto

    @Positive(message = "Preço deve ser positivo")  // Valida se é número positivo
    double price  // Preço do produto
) {
    // Record ideal para DTOs de entrada (imutável e conciso)
    // Anotações de validação serão verificadas automaticamente com @Valid
}

__________________________________________________________________________

// Endpoint melhorado com DTO e conversão para entidade
@PostMapping
public ResponseEntity<Product> create(@Valid @RequestBody ProductRequestDTO dto) {
    // Converte o DTO para a entidade Product
    Product product = new Product(dto.name(), dto.price());
    
    // Chama o serviço e retorna a entidade salva
    return ResponseEntity.ok(service.create(product));
    
    // ResponseEntity.ok() retorna status 200 com o corpo da resposta
}

__________________________________________________________________________


// Classe global para tratamento de exceções
@RestControllerAdvice  // Habilita tratamento global de exceções
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    // Tratamento específico para entidade não encontrada
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(EntityNotFoundException ex) {
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)  // Status 404
            .body(new ErrorResponse(ex.getMessage(), LocalDateTime.now()));
    }

    // Sobrescreve o tratamento padrão para erros de validação
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
        MethodArgumentNotValidException ex,  // Exceção de validação
        HttpHeaders headers,                // Cabeçalhos HTTP
        HttpStatusCode status,              // Status code
        WebRequest request                 // Requisição web
    ) {
        // Transforma os erros de campo em um Map<Campo, Mensagem>
        Map<String, String> errors = ex.getFieldErrors().stream()
            .collect(Collectors.toMap(
                FieldError::getField,         // Nome do campo com erro
                FieldError::getDefaultMessage // Mensagem de validação
            ));
            
        return ResponseEntity.badRequest().body(errors);  // Status 400 com os erros
    }
}

__________________________________________________________________________


// Método de serviço com tratamento de não encontrado
public Product findById(Long id) {
    return repository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado"));
        // Se não encontrar, lança exceção que será tratada pelo GlobalExceptionHandler
}

__________________________________________________________________________


// Versão estendida do ErrorResponse para incluir detalhes de validação
public record ErrorResponse(
    String message,               // Mensagem geral do erro
    LocalDateTime timestamp,      // Quando ocorreu
    Map<String, String> details   // Detalhes específicos (ex: erros de campo)
) {
    // Útil para erros de validação onde queremos mostrar:
    // - Mensagem geral ("Dados inválidos")
    // - Erros específicos por campo
}

__________________________________________________________________________

