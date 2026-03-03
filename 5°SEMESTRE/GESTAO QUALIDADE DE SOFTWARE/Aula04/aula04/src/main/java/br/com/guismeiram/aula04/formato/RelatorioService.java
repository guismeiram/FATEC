package br.com.guismeiram.aula04.formato;

public class RelatorioService {
    private RelatorioRepository repository;

    public RelatorioService(RelatorioRepository repository) {
        this.repository = repository;
    }

    public void gerar(FormatoRelatorio formato) {
        // Obtém os dados do repositório antes de gerar o relatório
        String dados = repository.obterDados();
        System.out.println("Dados obtidos: " + dados);

        // Delega a geração do formato específico para a estratégia
        formato.gerar();
    }
}
