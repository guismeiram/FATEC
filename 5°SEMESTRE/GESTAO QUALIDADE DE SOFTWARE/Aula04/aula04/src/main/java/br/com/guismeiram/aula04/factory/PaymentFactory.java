package br.com.guismeiram.aula04.factory;

public class PaymentFactory {
    public static PaymentMethod createPayment(String type) {
        return switch (type.toUpperCase()) {
            case "CREDIT_CARD" -> new CreditCard();
            case "PIX" -> new Pix();
            default -> throw new IllegalArgumentException("Tipo de pagamento inválido: " + type);
        };
    }
}
