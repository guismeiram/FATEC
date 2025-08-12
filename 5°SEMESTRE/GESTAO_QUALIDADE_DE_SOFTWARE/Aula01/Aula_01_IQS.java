public class CalculoSalario {
    public static void main(String[] args) {
        double s = 5000;            // Nome da variável muito curto ("s" não é descritivo)
        double d = calcular(s);      // "d" também não é claro (deveria ser "salarioLiquido")
        System.out.println("Salário líquido: " + d);
    }

    public static double calcular(double sl) {  // "sl" (salário?) poderia ter um nome mais claro
        double r = 0;               // "r" (desconto?) não é autoexplicativo
        if (sl < 1000) r = sl * 0.05;
        else if (sl < 2000) r = sl * 0.1;
        else if (sl < 4000) r = sl * 0.15;
        else r = sl * 0.2;
        return sl - r;               // Retorna salário líquido após desconto
    }
}

________________________________________________________

public class SalaryCalculator {
    public static void main(String[] args) {
        double grossSalary = 5000.0;          // Nome claro ("grossSalary" = salário bruto)
        double netSalary = calculateNetSalary(grossSalary);  // Nome autoexplicativo
        System.out.println("Net Salary: " + netSalary);
    }

    public static double calculateNetSalary(double grossSalary) {
        if (grossSalary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative."); // Validação
        }

        double taxRate = getTaxRate(grossSalary);  // Separa lógica da taxa em outro método
        double taxAmount = grossSalary * taxRate;
        return grossSalary - taxAmount;      // Retorna salário líquido
    }

    private static double getTaxRate(double salary) {  // Método dedicado à taxa
        if (salary < 1000) return 0.05;
        else if (salary < 2000) return 0.10;
        else if (salary < 4000) return 0.15;
        else return 0.20;
    }
}
________________________________________________________

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
________________________________________________________


public class OrderProcessor {
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