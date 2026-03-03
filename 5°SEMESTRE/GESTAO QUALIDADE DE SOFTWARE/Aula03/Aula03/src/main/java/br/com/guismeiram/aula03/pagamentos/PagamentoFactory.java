package br.com.guismeiram.aula03.pagamentos;

public class PagamentoFactory {
    public static MetodoPagamento criarMetodoPagamento(String tipo) {
        validarTipoPagamento(tipo);

        return switch (tipo.toUpperCase()) {
            case "CREDITO" -> new PagamentoCredito();
            case "BOLETO" -> new PagamentoBoleto();
            default -> throw new IllegalArgumentException("Tipo de pagamento não suportado: " + tipo);
        };
    }

    private static void validarTipoPagamento(String tipo) {
        if (tipo == null || tipo.trim().isEmpty()) {
            throw new IllegalArgumentException("Tipo de pagamento não pode ser nulo ou vazio");
        }
    }
}
