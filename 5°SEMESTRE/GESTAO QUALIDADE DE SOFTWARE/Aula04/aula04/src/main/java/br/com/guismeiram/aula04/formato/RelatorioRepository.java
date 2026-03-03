package br.com.guismeiram.aula04.formato;

public class RelatorioRepository {
    public String obterDados() {
        // Simula a obtenção de dados de uma fonte externa
        return "Dados do relatório - " + java.time.LocalDateTime.now();
    }
}
