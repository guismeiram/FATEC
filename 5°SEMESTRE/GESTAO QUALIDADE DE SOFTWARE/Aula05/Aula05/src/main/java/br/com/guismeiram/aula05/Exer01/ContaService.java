package br.com.guismeiram.aula05.Exer01;

public class ContaService {
    private double saldo;
    // Método para realizar saque em conta
    void sacar(double valor) {
        // Validação de saldo antes de realizar o saque
        if (valor > saldo) {
            // Lança exceção customizada com o saldo atual
            throw new SaldoInsuficienteException(saldo);
        }
        // ... (lógica de saque)
    }
}
