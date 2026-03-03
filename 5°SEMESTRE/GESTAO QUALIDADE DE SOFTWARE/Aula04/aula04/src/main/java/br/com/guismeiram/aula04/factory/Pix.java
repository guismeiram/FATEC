package br.com.guismeiram.aula04.factory;

public class Pix implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processando pagamento com PIX: R$" + String.format("%.2f", amount));
    }
}
