package br.com.guismeiram.aula04.factory;

public class DesignPatternsDemo {
    public static void main(String[] args) {
        // Obter instância do Logger
        Logger logger = Logger.getInstance();

        logger.log("Sistema iniciado");
        logger.log("Demonstração de padrões de projeto");

        // Demonstração da PaymentFactory
        System.out.println("\n=== Demonstração da PaymentFactory ===");

        try {
            // Criar pagamento com cartão de crédito
            PaymentMethod creditCard = PaymentFactory.createPayment("CREDIT_CARD");
            creditCard.processPayment(150.75);
            logger.log("Pagamento com cartão de crédito processado");

            // Criar pagamento com PIX
            PaymentMethod pix = PaymentFactory.createPayment("PIX");
            pix.processPayment(89.90);
            logger.log("Pagamento com PIX processado");

            // Tentar criar um tipo de pagamento inválido
            PaymentMethod invalid = PaymentFactory.createPayment("BOLETO");

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
            logger.log("Erro ao processar pagamento: " + e.getMessage());
        }

        // Demonstrar que o Logger é realmente um Singleton
        System.out.println("\n=== Verificando o Singleton ===");
        Logger anotherLogger = Logger.getInstance();
        anotherLogger.log("Esta mensagem vem da 'outra' instância do logger");

        // Mostrar que ambas as referências apontam para o mesmo objeto
        if (logger == anotherLogger) {
            System.out.println("logger e anotherLogger são a mesma instância! (Singleton funcionando)");
        }

        // Exibir histórico completo
        logger.printLogHistory();

        // Limpar o log
        logger.clearLog();
        logger.log("Log recomeçou");

        // Demonstrar mais usos da factory
        System.out.println("\n=== Mais exemplos de PaymentFactory ===");
        String[] paymentTypes = {"CREDIT_CARD", "PIX", "PIX", "CREDIT_CARD"};
        double[] amounts = {50.0, 25.5, 100.0, 200.0};

        for (int i = 0; i < paymentTypes.length; i++) {
            try {
                PaymentMethod payment = PaymentFactory.createPayment(paymentTypes[i]);
                payment.processPayment(amounts[i]);
                logger.log("Pagamento " + (i+1) + " processado: " + paymentTypes[i] + " - R$" + amounts[i]);
            } catch (IllegalArgumentException e) {
                System.out.println("Erro no pagamento " + (i+1) + ": " + e.getMessage());
            }
        }

        // Exibir histórico final
        logger.printLogHistory();
    }
}
