package br.com.guismeiram.aula04.calculadora;

public class CalculadoraImposto {
    double calcular(String tipo, double valor) {
        if (tipo.equals("ICMS")) {
            return valor * 0.10;
        } else if (tipo.equals("ISS")) {
            return valor * 0.05;
        }
        return 0;
    }

    public static void main(String[] args) {
        CalculadoraImposto calculadora = new CalculadoraImposto();

        // Exemplos de cálculo de impostos
        double valorProduto = 1000.00;

        double icms = calculadora.calcular("ICMS", valorProduto);
        double iss = calculadora.calcular("ISS", valorProduto);
        double outroImposto = calculadora.calcular("IPI", valorProduto);

        System.out.println("=== CÁLCULO DE IMPOSTOS ===");
        System.out.printf("Valor do produto: R$ %.2f%n", valorProduto);
        System.out.printf("ICMS (10%%): R$ %.2f%n", icms);
        System.out.printf("ISS (5%%): R$ %.2f%n", iss);
        System.out.printf("Outro imposto (IPI): R$ %.2f%n", outroImposto);
        System.out.println("===========================");

        // Teste com valores diferentes
        System.out.println("\n=== TESTES ADICIONAIS ===");
        double[] valoresTeste = {500.00, 750.50, 1250.75};

        for (double valor : valoresTeste) {
            System.out.printf("\nValor: R$ %.2f%n", valor);
            System.out.printf("ICMS: R$ %.2f%n", calculadora.calcular("ICMS", valor));
            System.out.printf("ISS: R$ %.2f%n", calculadora.calcular("ISS", valor));
        }
    }
}
