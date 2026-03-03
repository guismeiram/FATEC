package br.com.guismeiram.aula03.pagamentos;

public class PagamentoCredito implements MetodoPagamento {
    private static final double VALOR_MINIMO = 5.0;
    private static final double VALOR_MAXIMO = 5000.0;

    @Override
    public void processar(double valor) {
        if (!validar(valor)) {
            throw new IllegalArgumentException("Valor inválido para pagamento com crédito");
        }

        processarTaxa(valor);
        autorizarTransacao(valor);
        confirmarPagamento(valor);
    }

    @Override
    public boolean validar(double valor) {
        return valor >= VALOR_MINIMO && valor <= VALOR_MAXIMO;
    }

    private void processarTaxa(double valor) {
        double taxa = calcularTaxaCredito(valor);
        System.out.println("Processando taxa de R$" + taxa + " para pagamento com crédito");
    }

    private double calcularTaxaCredito(double valor) {
        return valor * 0.03; // 3% de taxa
    }

    private void autorizarTransacao(double valor) {
        System.out.println("Autorizando transação de crédito no valor de R$" + valor);
        // Lógica de autorização
    }

    private void confirmarPagamento(double valor) {
        System.out.println("Pagamento com crédito confirmado: R$" + valor);
        // Lógica de confirmação
    }
}
