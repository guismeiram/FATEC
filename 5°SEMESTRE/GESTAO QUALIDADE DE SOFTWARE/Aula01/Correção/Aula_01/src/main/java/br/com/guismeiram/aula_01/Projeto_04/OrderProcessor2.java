package br.com.guismeiram.aula_01.Projeto_04;

public class OrderProcessor2 {
    // Constantes bem definidas para regras de desconto
    private static final double DISCOUNT_THRESHOLD = 1000.0;  // Valor mínimo para aplicar desconto
    private static final double DISCOUNT_RATE = 0.9;           // 10% de desconto (representado como 0.9)

    /**
     * Calcula o valor total de um pedido com possibilidade de desconto
     * @param prices Array de preços dos itens
     * @param quantities Array de quantidades dos itens
     * @return Valor total do pedido com desconto aplicado (se elegível)
     * @throws IllegalArgumentException Se os arrays tiverem tamanhos diferentes
     */
    public double calculateTotal(double[] prices, int[] quantities) {
        // Validação importante para garantir consistência dos dados
        if (prices.length != quantities.length) {
            throw new IllegalArgumentException("Prices and quantities arrays must have the same length.");
        }

        // Cálculo do subtotal (sem desconto)
        double subtotal = 0;
        for (int i = 0; i < prices.length; i++) {
            subtotal += prices[i] * quantities[i];  // Soma o preço × quantidade de cada item
        }

        // Aplica desconto se o subtotal ultrapassar o threshold
        if (subtotal > DISCOUNT_THRESHOLD) {
            subtotal *= DISCOUNT_RATE;  // Aplica o desconto multiplicando pelo fator
        }

        return subtotal;
    }
}
