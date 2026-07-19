// Interface que estende JpaRepository para operações CRUD com a entidade Product
public interface ProductRepository extends JpaRepository<Product, Long> {  
    // Herda automaticamente métodos como:
    // save() - Salva/atualiza um produto
    // findAll() - Busca todos produtos
    // findById() - Busca por ID
    // deleteById() - Remove um produto
}

________________________________________________________________________

<!-- Dependências Maven para conexão com MySQL e Spring Data JPA -->
<dependency>  
    <groupId>mysql</groupId>  
    <artifactId>mysql-connector-java</artifactId>  <!-- Driver JDBC para MySQL -->
</dependency>  
<dependency>  
    <groupId>org.springframework.boot</groupId>  
    <artifactId>spring-boot-starter-data-jpa</artifactId>  <!-- Spring Data JPA -->
</dependency>

________________________________________________________________________

# Configurações do application.properties para conexão com banco de dados
spring.datasource.url=jdbc:mysql://localhost:3306/spring_db  # URL do banco MySQL
spring.datasource.username=root  # Usuário do banco
spring.datasource.password=senha123  # Senha do banco
spring.jpa.hibernate.ddl-auto=update  # Atualiza schema automaticamente (não usar em produção)

________________________________________________________________________

// Entidade JPA que representa a tabela no banco de dados
@Entity  // Indica que é uma entidade persistente
@Getter @Setter @NoArgsConstructor  // Lombok gera getters, setters e construtor vazio
public class Product {
    @Id  // Define como chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-incremento
    private Long id;
    
    @Column(nullable = false)  // Coluna não pode ser nula
    private String name;
    
    @Column(nullable = false)  // Coluna não pode ser nula
    private double price;
}

________________________________________________________________________

-- Comando SQL para criar o banco de dados (executar no MySQL)
CREATE DATABASE spring_db;  # Cria o banco de dados que será usado

________________________________________________________________________

// Repositório com método de consulta customizado
@Repository  // Indica que é um componente Spring para acesso a dados
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Consulta derivada - Spring implementa automaticamente
    List<Product> findByPriceLessThan(double price);  // Busca produtos com preço menor que
}

________________________________________________________________________

// Camada de serviço para regras de negócio
@Service  // Indica que é um componente de serviço
public class ProductService {
    @Autowired  // Injeção de dependência do repositório
    private ProductRepository repository;

    public List<Product> getAll() {
        return repository.findAll();  // Retorna todos produtos
    }

    public Product create(Product product) {
        return repository.save(product);  // Salva novo produto
    }
}

________________________________________________________________________

// Métodos adicionais no ProductService
public Product update(Long id, Product product) {
    product.setId(id);  // Garante que está atualizando o produto correto
    return repository.save(product);  // Atualiza ou cria se não existir
}

public void delete(Long id) {
    repository.deleteById(id);  // Remove produto pelo ID
}
________________________________________________________________________

// Entidade com validações avançadas
@Column(nullable = false, length = 100)  // Tamanho máximo 100 caracteres
@NotBlank(message = "Nome é obrigatório")  // Validação Bean Validation
private String name;

@Positive(message = "Preço deve ser positivo")  // Valida valor positivo
private double price;

________________________________________________________________________

// Endpoint REST para criação de produto
@PostMapping  // Mapeia requisições POST
public ResponseEntity<Product> create(@Valid @RequestBody Product product) {
    // @Valid valida o objeto conforme anotações na entidade
    // @RequestBody converte o JSON para objeto Product
    return ResponseEntity.status(201).body(service.create(product));  // Retorna 201 Created
}
________________________________________________________________________

