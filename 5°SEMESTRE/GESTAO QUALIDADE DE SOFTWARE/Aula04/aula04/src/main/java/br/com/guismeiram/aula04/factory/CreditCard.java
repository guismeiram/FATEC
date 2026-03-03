package br.com.guismeiram.aula04.factory;

public class CreditCard implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processando pagamento com cartão de crédito: R$" + String.format("%.2f", amount));
    }
}
