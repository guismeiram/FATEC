package br.com.guismeiram.aula04.imposto;

public class ISS implements ImpostoStrategy {
    @Override
    public double calcular(double valor) {
        // ISS: 5% do valor
        return valor * 0.05;
    }
}