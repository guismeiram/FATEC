package br.com.guismeiram.aula04.imposto;

public class Main {
    public static void main(String[] args) {
        CalculadoraImposto calculadora = new CalculadoraImposto();

        ICMS icms = new ICMS();
        ISS iss = new ISS();

        double valorProduto = 100.0;

        System.out.println("ICMS: R$" + calculadora.calcular(icms, valorProduto));
        System.out.println("ISS: R$" + calculadora.calcular(iss, valorProduto));
    }
}
