package br.com.guismeiram.aula03.pagamentos;

public class PagamentoBoleto implements MetodoPagamento {
    private static final double VALOR_MINIMO = 1.0;
    private static final double VALOR_MAXIMO = 10000.0;

    @Override
    public void processar(double valor) {
        if (!validar(valor)) {
            throw new IllegalArgumentException("Valor inválido para pagamento com boleto");
        }

        gerarCodigoBarras(valor);
        registrarBoleto(valor);
        enviarComprovante(valor);
    }

    @Override
    public boolean validar(double valor) {
        return valor >= VALOR_MINIMO && valor <= VALOR_MAXIMO;
    }

    private void gerarCodigoBarras(double valor) {
        String codigoBarras = gerarCodigoUnico(valor);
        System.out.println("Código de barras gerado: " + codigoBarras);
    }

    private String gerarCodigoUnico(double valor) {
        return "34191.12345 67890.123456 78901.234567 8 " + String.format("%.2f", valor).replace(",", "");
    }

    private void registrarBoleto(double valor) {
        System.out.println("Boleto registrado no valor de R$" + valor);
        // Lógica de registro
    }

    private void enviarComprovante(double valor) {
        System.out.println("Comprovante de boleto enviado para valor: R$" + valor);
        // Lógica de envio
    }
}