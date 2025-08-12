name: Java CI Pipeline  # Nome da pipeline
on: [push, pull_request]  # Dispara em pushes e pull requests

jobs:
  build:
    runs-on: ubuntu-latest  # Executa em container Ubuntu
    steps:
      - uses: actions/checkout@v3  # Faz checkout do código
      
      - name: Set up JDK 17  # Configura Java 17
        uses: actions/setup-java@v3
        with:
          java-version: '17'
          distribution: 'temurin'  # Usa a distribuição Eclipse Temurin
      
      - name: Build and Test  # Executa build e testes
        run: mvn clean verify  # Limpa, compila e executa testes
        
      - name: SonarQube Scan  # Análise estática de código
        uses: SonarSource/sonarqube-scan-action@master
        env:
          SONAR_TOKEN: ${{ secrets.SONAR_TOKEN }}  # Token de autenticação
          SONAR_HOST_URL: ${{ secrets.SONAR_HOST_URL }}  # URL do SonarQube
		  
		  
__________________________________________________________________

// src/test/java/com/example/projeto/domain/service/ProdutoServiceTest.java


@ExtendWith(MockitoExtension.class)  // Habilita Mockito
class ProdutoServiceTest {
    @Mock
    ProdutoRepository repository;  // Mock do repositório
    
    @InjectMocks
    ProdutoService service;  // Injeta os mocks

    @Test
    void deveBuscarProdutosPorNome() {
        // Configura comportamento do mock
        when(repository.findByNomeContaining("Xiaomi"))
            .thenReturn(List.of(new Produto("Smartphone Xiaomi")));
        
        // Chama o método sendo testado
        List<Produto> result = service.buscarPorNome("Xiaomi");
        
        // Verificações
        assertEquals(1, result.size());  // Verifica resultado
        verify(repository).findByNomeContaining("Xiaomi");  // Verifica interação
    }
}

__________________________________________________________________

// src/test/java/com/example/projeto/interface/rest/ProdutoControllerIT.java

@Testcontainers  // Habilita Testcontainers
class ProdutoControllerIT {
    @Container
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:15");  // Container PostgreSQL
    
    // Configura dinamicamente propriedades do Spring
    @DynamicPropertySource
    static void configure(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
    }
    
    @Test
    void devePersistirProdutoNoBancoReal() {
        // Teste que interage com o banco real no container
    }
}

__________________________________________________________________


mvn clean verify sonar:sonar  # Limpa, testa e executa análise SonarQube

__________________________________________________________________

// Antes (problema: possível NullPointerException)
public BigDecimal getPrecoFormatado() {
    return preco.setScale(2, RoundingMode.HALF_UP);  // Risco se preco for null
}

// Depois (solução defensiva)
public BigDecimal getPrecoFormatado() {
    return preco != null ? preco.setScale(2, RoundingMode.HALF_UP) : BigDecimal.ZERO;  // Trata null
}

__________________________________________________________________

- name: Deploy to Heroku
  if: github.ref == 'refs/heads/main'  # Só executa no branch main
  run: |
    curl https://cli-assets.heroku.com/install.sh | sh  # Instala Heroku CLI
    heroku deploy:jar target/*.jar --app ${{ secrets.HEROKU_APP_NAME }}  # Faz deploy