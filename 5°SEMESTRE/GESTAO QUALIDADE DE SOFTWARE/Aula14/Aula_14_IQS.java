// src/main/java/com/example/projeto/domain/repository/ProdutoRepository.java

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    // Query Method - Spring Data gera a query automaticamente
    List<Produto> findByNomeContaining(String nome); // Busca produtos que contenham o texto no nome
}

________________________________________________________

// src/main/java/com/example/projeto/interface/rest/ProdutoController.java

@GetMapping("/buscar") // Mapeia para GET /produtos/buscar
public List<Produto> buscarPorNome(@RequestParam String nome) { // Recebe parâmetro de query string
    return repository.findByNomeContaining(nome); // Chama o método do repositório
}

________________________________________________________

// src/test/java/com/example/projeto/interface/rest/ProdutoControllerIT.java

@Test
void deveBuscarProdutosPorNome() throws Exception {
    // Pré-condição: salva um produto no banco
    repository.save(new Produto("Smartphone Xiaomi"));
    
    // Executa requisição e verifica resultados
    mockMvc.perform(get("/produtos/buscar?nome=Xiaomi")) // Faz a busca
           .andExpect(status().isOk()) // Verifica status 200
           .andExpect(jsonPath("$[0].nome", containsString("Xiaomi"))); // Valida conteúdo
}

________________________________________________________

git checkout -b feature/us-001-busca-produtos # Cria branch para a user story
git add . # Adiciona alterações
git commit -m "Implementa US-001: Busca de produtos por nome" # Commit semântico
git push origin feature/us-001-busca-produtos # Envia para o repositório

________________________________________________________

name: SonarQube Analysis
on: [pull_request] # Dispara em pull requests
jobs:
  sonarqube:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v3 # Faz checkout do código
      - name: SonarQube Scan
        uses: SonarSource/sonarqube-scan-action@master
        env:
          SONAR_TOKEN: ${{ secrets.SONAR_TOKEN }} # Token de autenticação
		  
________________________________________________________

