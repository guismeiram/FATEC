// Criação manual de um mock para UsuarioRepository
UsuarioRepository mockRepo = Mockito.mock(UsuarioRepository.class);

// Configurando comportamento do mock - quando buscarPorId(1L) for chamado, retorna um usuário "Admin"
when(mockRepo.buscarPorId(1L)).thenReturn(new Usuario("Admin"));

// Verificando se o método salvar foi chamado exatamente 1 vez com qualquer instância de Usuario
verify(mockRepo, times(1)).salvar(any(Usuario.class));

_____________________________________________________________________

<!-- Dependência do Mockito para criação de mocks em testes -->
<dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-core</artifactId>
    <version>5.3.1</version>
    <scope>test</scope> <!-- Disponível apenas em tempo de teste -->
</dependency>

_____________________________________________________________________

// Classe de teste para UsuarioService usando Mockito
class UsuarioServiceTest {

    @Mock // Cria um mock automaticamente
    UsuarioRepository repository;

    @InjectMocks // Injeta os mocks na classe de serviço sendo testada
    UsuarioService service;

    @BeforeEach
    void setup() {
        // Inicializa os mocks anotados
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveRetornarUsuarioQuandoExistir() {
        // Configura o comportamento do mock
        when(repository.buscarPorId(1L))
            .thenReturn(new Usuario("João"));

        // Chama o método sendo testado
        Usuario resultado = service.buscarUsuario(1L);

        // Verifica o resultado
        assertEquals("João", resultado.getNome());
        // Verifica se o método do mock foi chamado como esperado
        verify(repository, times(1)).buscarPorId(1L);
    }
}
_____________________________________________________________________


<!-- Dependências do Testcontainers para testes de integração -->
<dependency>
    <groupId>org.testcontainers</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>1.18.3</version>
    <scope>test</scope>
</dependency>
<!-- Extensão específica para PostgreSQL -->
<dependency>
    <groupId>org.testcontainers</groupId>
    <artifactId>postgresql</artifactId>
    <version>1.18.3</version>
    <scope>test</scope>
</dependency>

_____________________________________________________________________

// Classe de teste de integração usando Testcontainers
@Testcontainers // Habilita o suporte a containers
class UsuarioRepositoryIT {

    // Define um container PostgreSQL com a versão 15
    @Container
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:15");

    @BeforeAll
    static void setup() {
        // Obtém a URL de conexão do container
        String jdbcUrl = postgres.getJdbcUrl();
        // Configura o DataSource com o banco de dados do container
    }

    @Test
    void deveSalvarUsuarioNoBanco() {
        Usuario usuario = new Usuario("Maria");
        repository.salvar(usuario);

        // Verifica se o usuário foi persistido corretamente
        Usuario salvado = repository.buscarPorId(usuario.getId());
        assertEquals("Maria", salvado.getNome());
    }
}

_____________________________________________________________________

<!-- Plugin JaCoCo para cobertura de código -->
<plugin>
    <groupId>org.jacoco</groupId>
    <artifactId>jacoco-maven-plugin</artifactId>
    <version>0.8.10</version>
    <executions>
        <execution>
            <goals>
                <goal>prepare-agent</goal> <!-- Prepara o agente JaCoCo -->
            </goals>
        </execution>
        <execution>
            <phase>test</phase> <!-- Executa após os testes -->
            <goals>
                <goal>report</goal> <!-- Gera o relatório de cobertura -->
            </goals>
        </execution>
    </executions>
</plugin>

_____________________________________________________________________

# Comando para executar os testes e gerar relatório de cobertura
mvn clean test
# O relatório JaCoCo é gerado em: target/site/jacoco/index.html
_____________________________________________________________________

// Teste simulando falha em chamada HTTP
@Mock
EstoqueClient estoqueClient; // Mock para cliente de estoque

@Test
void deveFalharQuandoEstoqueInsuficiente() {
    // Configura o mock para lançar exceção quando reservar for chamado
    when(estoqueClient.reservar(anyLong(), anyInt()))
        .thenThrow(new EstoqueInsuficienteException());

    // Verifica se a exceção é lançada ao tentar reservar estoque
    assertThrows(EstoqueInsuficienteException.class,
        () -> service.reservarEstoque(1L, 100));
}

_____________________________________________________________________

