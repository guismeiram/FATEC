package br.com.guismeiram.aula04.relatorio;

public class Relatorio {
    void gerarRelatorio(String tipo) {
        if (tipo.equals("PDF")) {
            // Lógica complexa de PDF
            System.out.println("Gerando relatório em formato PDF...");
            configurarPaginaPDF();
            aplicarEstilosPDF();
            gerarConteudoPDF();
            finalizarPDF();
        } else if (tipo.equals("HTML")) {
            // Lógica complexa de HTML
            System.out.println("Gerando relatório em formato HTML...");
            criarEstruturaHTML();
            aplicarCSS();
            gerarConteudoHTML();
            validarHTML();
        } else {
            System.out.println("Formato de relatório não suportado: " + tipo);
        }
    }

    void salvarNoBanco() {
        // Lógica de BD
        System.out.println("Salvando relatório no banco de dados...");
        conectarBanco();
        prepararStatement();
        executarInsert();
        confirmarTransacao();
        fecharConexao();
    }

    // Métodos auxiliares para PDF
    private void configurarPaginaPDF() {
        System.out.println("Configurando página PDF - tamanho A4, margens");
    }

    private void aplicarEstilosPDF() {
        System.out.println("Aplicando estilos PDF - fontes, cores, tabelas");
    }

    private void gerarConteudoPDF() {
        System.out.println("Gerando conteúdo específico do PDF");
    }

    private void finalizarPDF() {
        System.out.println("Finalizando documento PDF - compactando, otimizando");
    }

    // Métodos auxiliares para HTML
    private void criarEstruturaHTML() {
        System.out.println("Criando estrutura HTML - doctype, head, body");
    }

    private void aplicarCSS() {
        System.out.println("Aplicando CSS - estilos, responsividade");
    }

    private void gerarConteudoHTML() {
        System.out.println("Gerando conteúdo específico do HTML");
    }

    private void validarHTML() {
        System.out.println("Validando código HTML - W3C standards");
    }

    // Métodos auxiliares para banco de dados
    private void conectarBanco() {
        System.out.println("Conectando ao banco de dados...");
    }

    private void prepararStatement() {
        System.out.println("Preparando SQL statement...");
    }

    private void executarInsert() {
        System.out.println("Executando INSERT no banco...");
    }

    private void confirmarTransacao() {
        System.out.println("Confirmando transação...");
    }

    private void fecharConexao() {
        System.out.println("Fechando conexão com o banco...");
    }

    public static void main(String[] args) {
        Relatorio relatorio = new Relatorio();

        System.out.println("=== GERANDO RELATÓRIO PDF ===");
        relatorio.gerarRelatorio("PDF");
        System.out.println("\n=== SALVANDO NO BANCO ===");
        relatorio.salvarNoBanco();

        System.out.println("\n=== GERANDO RELATÓRIO HTML ===");
        relatorio.gerarRelatorio("HTML");
        System.out.println("\n=== SALVANDO NO BANCO ===");
        relatorio.salvarNoBanco();

        System.out.println("\n=== TESTANDO FORMATO NÃO SUPORTADO ===");
        relatorio.gerarRelatorio("XML");

        System.out.println("\n=== TESTE COMPLETO ===");
    }
}
