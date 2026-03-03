package br.com.guismeiram.aula03.pagamentos;

public interface MetodoPagamento {
    void processar(double valor);
    boolean validar(double valor);
}
