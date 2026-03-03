package br.com.guismeiram.aula04.imposto;

public class ICMS implements ImpostoStrategy {
    @Override
    public double calcular(double valor) {
        // ICMS: 17% do valor
        return valor * 0.17;
    }
}
