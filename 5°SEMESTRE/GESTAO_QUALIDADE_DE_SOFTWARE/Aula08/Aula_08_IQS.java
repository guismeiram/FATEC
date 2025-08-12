# Arquivo de feature no formato Gherkin
# Descrição da funcionalidade no formato BDD (Behavior-Driven Development)
Funcionalidade: Calculadora de soma
  # Definição de persona e objetivo
  Como um usuário
  Eu quero somar dois números
  Para obter o resultado correto

  # Cenário de teste com exemplos concretos
  Cenário: Soma de números positivos
    Dado que eu tenho os números 2 e 3  # Pré-condição
    Quando eu somo estes números        # Ação
    Então o resultado deve ser 5        # Resultado esperado
	
_________________________________________________________________

<!-- Dependências do Cucumber para BDD em Java -->
<dependency>
    <groupId>io.cucumber</groupId>
    <artifactId>cucumber-java</artifactId>
    <version>7.14.0</version>  <!-- Implementação das definições de steps -->
</dependency>
<dependency>
    <groupId>io.cucumber</groupId>
    <artifactId>cucumber-junit</artifactId>
    <version>7.14.0</version>  <!-- Integração com JUnit -->
</dependency>

_________________________________________________________________

# Feature com múltiplos cenários
Funcionalidade: Calculadora

  # Cenário de sucesso
  Cenário: Soma de dois números
    Dado que eu tenho os números 5 e 7
    Quando eu peço para somar
    Então o resultado deve ser 12

  # Cenário de tratamento de erro
  Cenário: Divisão por zero
    Dado que eu tenho os números 10 e 0
    Quando eu peço para dividir
    Então o sistema deve informar "Divisão por zero não permitida"

_________________________________________________________________

// Classe de implementação dos steps (passos) do Gherkin
public class CalculadoraSteps {
    // Variáveis para armazenar estado entre os steps
    private int num1, num2;
    private int resultado;
    private Exception exception;

    // Step para definir os números (usa parâmetros do cenário)
    @Dado("que eu tenho os números {int} e {int}")
    public void definir_numeros(int a, int b) {
        this.num1 = a;
        this.num2 = b;
    }

    // Step para executar a soma
    @Quando("eu peço para somar")
    public void somar() {
        this.resultado = Calculadora.somar(num1, num2);
    }

    // Step para verificar o resultado
    @Então("o resultado deve ser {int}")
    public void verificar_resultado(int esperado) {
        assertEquals(esperado, resultado);  // Asserção JUnit
    }

    // Step para executar a divisão (com tratamento de erro)
    @Quando("eu peço para dividir")
    public void dividir() {
        try {
            this.resultado = Calculadora.dividir(num1, num2);
        } catch (Exception e) {
            this.exception = e;  // Captura a exceção para verificação posterior
        }
    }

    // Step para verificar mensagem de erro
    @Então("o sistema deve informar {string}")
    public void verificar_mensagem(String mensagem) {
        assertNotNull(exception);  // Verifica se houve exceção
        assertEquals(mensagem, exception.getMessage());  // Verifica a mensagem
    }
}

_________________________________________________________________

// Classe runner para executar os testes do Cucumber
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)  // Usa o executor do Cucumber
@CucumberOptions(
    features = "src/test/resources/features",  // Local das features
    glue = "steps",  // Pacote com as classes de steps
    plugin = {"pretty", "html:target/cucumber-reports.html"}  // Plugins de relatório
)
public class TestRunner {}  // Runner vazio - configuração via anotações


_________________________________________________________________

# Feature de autenticação com cenários positivos e negativos
Funcionalidade: Autenticação de usuário

  # Cenário de sucesso
  Cenário: Login válido
    Dado que o usuário "admin" com senha "1234" está cadastrado
    Quando eu faço login com "admin" e "1234"
    Então o acesso é concedido

  # Cenário de falha
  Cenário: Senha inválida
    Dado que o usuário "admin" com senha "1234" está cadastrado
    Quando eu faço login com "admin" e "senhaerrada"
    Então o acesso é negado
	
_________________________________________________________________
	
	