package br.com.guismeiram.aula04.formato;

public class Main {
    public static void main(String[] args) {
        // Cria o repositório
        RelatorioRepository repository = new RelatorioRepository();

        // Cria o serviço de relatório
        RelatorioService relatorioService = new RelatorioService(repository);

        // Testa geração de relatório em PDF
        System.out.println("=== Teste de Relatório PDF ===");
        FormatoRelatorio pdf = new PDF();
        relatorioService.gerar(pdf);

        System.out.println(); // Linha em branco para separar

        // Testa geração de relatório em HTML
        System.out.println("=== Teste de Relatório HTML ===");
        FormatoRelatorio html = new HTML();
        relatorioService.gerar(html);

        System.out.println(); // Linha em branco para separar

        // Demonstração do uso com lambda (Java 8+)
        System.out.println("=== Teste com Formato Personalizado (Lambda) ===");
        FormatoRelatorio personalizado = () -> {
            System.out.println("Gerando relatório em formato personalizado...");
            // Lógica personalizada aqui
        };
        relatorioService.gerar(personalizado);
    }
}
