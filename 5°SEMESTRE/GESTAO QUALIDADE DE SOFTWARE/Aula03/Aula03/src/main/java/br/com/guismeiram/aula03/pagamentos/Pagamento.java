package br.com.guismeiram.aula03.pagamentos;

public class Pagamento {
    public void processar(String tipo, double valor) {
        validarParametros(tipo, valor);

        MetodoPagamento metodo = PagamentoFactory.criarMetodoPagamento(tipo);
        metodo.processar(valor);
    }

    private void validarParametros(String tipo, double valor) {
        validarTipoNaoNulo(tipo);
        validarValorPositivo(valor);
    }

    private void validarTipoNaoNulo(String tipo) {
        if (tipo == null) {
            throw new IllegalArgumentException("Tipo de pagamento não pode ser nulo");
        }
    }

    private void validarValorPositivo(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor do pagamento deve ser positivo");
        }
    }

    public static void main(String[] args) {
        Pagamento pagamento = new Pagamento();

        try {
            pagamento.processar("CREDITO", 100.0);
            pagamento.processar("BOLETO", 250.0);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
