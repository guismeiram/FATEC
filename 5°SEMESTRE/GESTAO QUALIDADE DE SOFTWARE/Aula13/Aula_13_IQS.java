git clone <seu-repositorio>  # Clona o repositório Git
cd <projeto>                 # Navega para o diretório do projeto

________________________________________________________

// Modelo de domínio Produto com JPA e Lombok
@Entity                      // Indica que é uma entidade JPA
@Data                        // Gera getters, setters, toString, etc. (Lombok)
@NoArgsConstructor           // Construtor sem argumentos (Lombok)
public class Produto {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)  // ID auto-increment
    private Long id;
    
    @Column(nullable = false)  // Coluna não nula no banco
    private String nome;       // Nome do produto
    
    @Column(precision = 10, scale = 2)  // Preço com 10 dígitos e 2 decimais
    private BigDecimal preco;  // Tipo ideal para valores monetários
}

________________________________________________________

// Interface do repositório com Spring Data JPA
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}

________________________________________________________

// Controller REST para operações com produtos
@RestController             // Indica que é um controller REST
@RequestMapping("/produtos") // Mapeia todas as rotas para /produtos
@RequiredArgsConstructor    // Injeta dependências via construtor (Lombok)
public class ProdutoController {
    private final ProdutoRepository repository;  // Injeção de dependência

    @GetMapping             // Mapeia GET /produtos
    public List<Produto> listar() {
        return repository.findAll();  // Retorna todos os produtos
    }

    @PostMapping            // Mapeia POST /produtos
    @ResponseStatus(HttpStatus.CREATED)  // Retorna status 201
    public Produto criar(@RequestBody Produto produto) {  // Recebe JSON no body
        return repository.save(produto);  // Salva o produto
    }
}

________________________________________________________

// Teste de integração com MockMvc
@SpringBootTest             // Carrega todo o contexto Spring
@AutoConfigureMockMvc       // Configura MockMvc automaticamente
class ProdutoControllerIT {
    @Autowired
    MockMvc mockMvc;        // Cliente para testar controllers REST

    @Test
    void deveListarProdutosVazios() throws Exception {
        mockMvc.perform(get("/produtos"))  // Faz requisição GET
               .andExpect(status().isOk()) // Verifica status 200
               .andExpect(jsonPath("$", hasSize(0)));  // Verifica array vazio
    }
}

________________________________________________________

// Teste unitário com Mockito
@ExtendWith(MockitoExtension.class)  // Habilita Mockito
class ProdutoControllerTest {
    @Mock
    ProdutoRepository repository;    // Mock do repositório
    
    @InjectMocks
    ProdutoController controller;   // Injeta o mock no controller

    @Test
    void deveChamarRepositoryAoListar() {
        controller.listar();        // Chama o método
        verify(repository).findAll();  // Verifica se o mock foi chamado
    }
}

________________________________________________________

<!-- Plugin Maven para cobertura de código -->
<plugin>
    <groupId>org.jacoco</groupId>
    <artifactId>jacoco-maven-plugin</artifactId>
    <version>0.8.10</version>  <!-- Versão do JaCoCo -->
</plugin>

________________________________________________________

mvn clean test jacoco:report  # Executa testes e gera relatório
# Relatório em: target/site/jacoco/index.html  # HTML com cobertura
________________________________________________________


git tag -a v0.1 -m "MVP inicial"  # Cria tag anotada
git push origin v0.1              # Envia tag para o repositório remoto

________________________________________________________
