package br.com.guismeiram.aula_01.Projeto_03;

public class OrderProcessor {
    public double calcTotal(double[] prices, int qty[]) {
        double t = 0;  // "t" poderia ser "total" ou "subtotal"
        for (int i = 0; i < prices.length; i++) {
            t += prices[i] * qty[i];  // Soma preço × quantidade
        }
        if (t > 1000) {
            t = t * 0.9;  // Aplica 10% de desconto se total > 1000
        }
        return t;
    }
}
