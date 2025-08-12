// Importações para testes JUnit 5
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

// Classe de teste para a Calculadora
class CalculadoraTest {

    // Método executado uma vez antes de todos os testes
    @BeforeAll
    static void setup() { /* Inicialização global de recursos */ }

    // Método executado antes de cada teste
    @BeforeEach
    void init() { /* Pré-configuração para cada teste */ }

    // Caso de teste com nome descritivo
    @Test
    @DisplayName("Soma de 2 + 2 deve ser 4")
    void testSoma() {
        // Asserção que verifica o resultado esperado
        assertEquals(4, Calculadora.somar(2, 2));
    }

    // Método executado após cada teste
    @AfterEach
    void tearDown() { /* Limpeza pós-teste */ }
}

______________________________________________________________


// Classe principal da calculadora
public class Calculadora {
    // Método para somar dois inteiros
    public static int somar(int a, int b) {
        return a + b;
    }

    // Método para divisão com tratamento de erro
    public static double dividir(int a, int b) {
        if (b == 0) throw new DivisaoPorZeroException(); // Validação de divisão por zero
        return (double) a / b; // Cast para preservar casas decimais
    }
}

______________________________________________________________

// Teste que verifica o lançamento de exceção
@Test
@DisplayName("Divisão por zero deve lançar exceção")
void testDivisaoPorZero() {
    // Verifica se a exceção é lançada
    assertThrows(DivisaoPorZeroException.class, 
        () -> Calculadora.dividir(1, 0));
}

______________________________________________________________


<!-- Dependência para testes parametrizados no JUnit 5 -->
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-params</artifactId>
    <version>5.9.0</version>
    <scope>test</scope> <!-- Só disponível em tempo de teste -->
</dependency>

______________________________________________________________

// Teste parametrizado com fonte de dados
@ParameterizedTest
@MethodSource("geradorDeTestes")
void testSomaComParametros(int a, int b, int esperado) {
    assertEquals(esperado, Calculadora.somar(a, b));
}

// Fonte de dados para o teste parametrizado
private static Stream<Arguments> geradorDeTestes() {
    return Stream.of(
        Arguments.of(1, 1, 2),   // Caso positivo
        Arguments.of(-1, -1, -2), // Caso negativo
        Arguments.of(0, 5, 5)     // Caso com zero
    );
}

______________________________________________________________

// Serviço de validação de usuário
public class UsuarioService {
    // Valida se a senha tem pelo menos 8 caracteres
    public boolean validarSenha(String senha) {
        return senha != null && senha.length() >= 8;
    }
}

______________________________________________________________

// Classe aninhada para organizar testes relacionados
@Nested
class ValidacaoSenhaTest {
    @Test
    void senhaNula() {
        assertFalse(service.validarSenha(null)); // Teste para senha nula
    }
    // Outros testes específicos para validação de senha...
}

______________________________________________________________

// Teste tradicional com múltiplas asserções (não ideal)
@Test
void testCalculadora() {
    assertEquals(3, Calculadora.somar(1, 2));  // Caso positivo
    assertEquals(-1, Calculadora.somar(1, -2)); // Caso negativo
    assertEquals(0, Calculadora.somar(0, 0));  // Caso zero
}

______________________________________________________________

// Teste parametrizado com CSV e múltiplas asserções
@ParameterizedTest
@CsvSource({"1, 2, 3", "1, -2, -1", "0, 0, 0"})
void testSomaParametrizada(int a, int b, int esperado) {
    // Agrupamento de asserções (todas são executadas)
    assertAll(
        () -> assertEquals(esperado, Calculadora.somar(a, b)),
        () -> assertTrue(a + b == esperado) // Validação redundante
    );
}

______________________________________________________________

