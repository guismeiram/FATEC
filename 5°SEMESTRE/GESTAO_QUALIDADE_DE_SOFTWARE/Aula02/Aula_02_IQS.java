/**
 * Classe utilitária para operações matemáticas básicas.
 * Fornece métodos estáticos para cálculos simples.
 */
public class Calculator {
    /**
     * Realiza a adição de dois números inteiros.
     * @param a Primeiro operando (número a ser somado)
     * @param b Segundo operando (número a ser somado)
     * @return Resultado da soma a + b
     * @throws ArithmeticException Se ocorrer overflow na operação
     */
    public static int add(int a, int b) {
        return a + b;
    }
}

_______________________________________________________

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de testes unitários para a classe Calculator.
 * Verifica o comportamento correto dos métodos de cálculo.
 */
public class CalculatorTest {
    /**
     * Testa a função de adição com valores positivos.
     * Verifica se 2 + 2 resulta em 4.
     */
    @Test
    public void testAdd() {
        assertEquals(4, Calculator.add(2, 2));
    }
}

_______________________________________________________

name: Java CI  # Nome do workflow de Integração Contínua

on: [push, pull_request]  # Dispara em pushes e pull requests

jobs:
  build:
    runs-on: ubuntu-latest  # Executa no Ubuntu
    
    steps:
      - uses: actions/checkout@v2  # Checkout do código
      
      - name: Set up JDK 17  # Configura JDK 17
        uses: actions/setup-java@v2
        with:
          java-version: '17'
          distribution: 'temurin'  # Usa a distribuição Temurin
      
      - name: Build and Test with Maven  # Executa build e testes
        run: mvn clean test  # Comando Maven para limpar e testar
		
# Adiciona todas as alterações ao stage
git add .

# Cria um commit com a mensagem descritiva
git commit -m "Adiciona pipeline CI"

# Envia as alterações para o branch main no repositório remoto
git push origin main
_______________________________________________________
// Em Calculator.java
/**
 * Realiza a subtração de dois números inteiros.
 * @param a Minuendo (número a ser subtraído)
 * @param b Subtraendo (número a subtrair)
 * @return Resultado da subtração a - b
 */
public static int subtract(int a, int b) {
    return a - b;
}
_______________________________________________________

// Em CalculatorTest.java
/**
 * Testa a função de subtração com valores positivos.
 * Verifica se 3 - 2 resulta em 1.
 */
@Test
public void testSubtract() {
    assertEquals(1, Calculator.subtract(3, 2));
}
_______________________________________________________

