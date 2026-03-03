package br.com.guismeiram.aula04.imposto;

public class CalculadoraImposto {
    double calcular(ImpostoStrategy imposto, double valor) {
        return imposto.calcular(valor);
    }
}
