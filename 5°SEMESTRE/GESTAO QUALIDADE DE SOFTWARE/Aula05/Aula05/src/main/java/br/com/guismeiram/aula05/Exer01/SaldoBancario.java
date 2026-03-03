package br.com.guismeiram.aula05.Exer01;

import java.math.BigDecimal;

public class SaldoBancario {
}
// Exceção personalizada para saldo insuficiente
public class SaldoInsuficienteException extends RuntimeException {
    public SaldoInsuficienteException(String message) {
        super(message);
    }
}

// Classe Conta (simplificada)
class Conta {
    private String numero;
    private BigDecimal saldo;

    public Conta(String numero, BigDecimal saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    public String getNumero() { return numero; }
    public BigDecimal getSaldo() { return saldo; }

    public void debitar(BigDecimal valor) {
        saldo = saldo.subtract(valor);
    }

    public void creditar(BigDecimal valor) {
        saldo = saldo.add(valor);
    }
}
