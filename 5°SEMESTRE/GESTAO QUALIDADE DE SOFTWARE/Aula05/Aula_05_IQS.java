// Exceção customizada para representar erros de saldo insuficiente
// Herda de RuntimeException (unchecked exception)
public class SaldoInsuficienteException extends RuntimeException {
    // Construtor que recebe o saldo atual para compor a mensagem
    public SaldoInsuficienteException(double saldoAtual) {
        super("Saldo insuficiente. Disponível: " + saldoAtual); // Mensagem descritiva
    }
}

________________________________________________________________________


class ContaService {
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
________________________________________________________________________

<!-- Dependência do Log4j2 para logging/tracing na aplicação -->
<!-- Versão 2.20.0 - importante verificar vulnerabilidades conhecidas -->
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-core</artifactId>
    <version>2.20.0</version>
</dependency>

________________________________________________________________________

<!-- Configuração do Log4j2 -->
<Configuration>
    <!-- Appenders - Destinos dos logs -->
    <Appenders>
        <!-- Appender para console com formatação personalizada -->
        <Console name="Console" target="SYSTEM_OUT">
            <PatternLayout pattern="%d{HH:mm:ss} [%t] %-5level %logger{36} - %msg%n"/>
        </Console>
    </Appenders>
    <!-- Loggers - Configuração de níveis de log -->
    <Loggers>
        <!-- Logger root (padrão) com nível DEBUG -->
        <Root level="DEBUG">
            <AppenderRef ref="Console"/> <!-- Usa o appender Console -->
        </Root>
    </Loggers>
</Configuration>

________________________________________________________________________

// Logger estático para a classe ContaService
private static final Logger logger = LogManager.getLogger(ContaService.class);

// Método de transferência com tratamento de erros
void transferir() {
    logger.info("Iniciando transferência"); // Log nível INFO
    try {
        // ... (lógica de transferência)
    } catch (SaldoInsuficienteException e) {
        // Log nível ERROR com mensagem formatada
        logger.error("Falha na transferência: {}", e.getMessage());
        throw e; // Re-lança a exceção
    }
}

________________________________________________________________________


<!-- Dependência do Sentry para monitoramento de erros -->
<!-- Integração com Log4j2 -->
<dependency>
    <groupId>io.sentry</groupId>
    <artifactId>sentry-log4j2</artifactId>
    <version>6.25.0</version>
</dependency>

________________________________________________________________________

<!-- Configuração adicional do Appender para Sentry -->
<Appenders>
    <!-- Appender do Sentry para capturar apenas erros (level ERROR) -->
    <Sentry name="Sentry" level="ERROR"/>
</Appenders>

________________________________________________________________________

// Exemplo de captura de erro crítico
try {
    throw new RuntimeException("Erro crítico!");
} catch (Exception e) {
    // Log que será capturado pelo Sentry
    logger.error("Erro capturado pelo Sentry", e);
}
________________________________________________________________________

class CadastroUsuario {
    // Método com validação simples (poderia usar exceções)
    void cadastrar(String nome, int idade) {
        if (idade < 18) {
            // Uso de System.err (não recomendado para produção)
            System.err.println("Usuário menor de idade");
        }
        // ...
    }
    
    // Método com manipulação de arquivo (antipatterns)
    void salvarArquivo(String path) {
        FileWriter fw = null; // Inicialização fora do try
        try {
            fw = new FileWriter(path);
            // ...
        } catch (IOException e) {
            e.printStackTrace(); // Forma não ideal de tratar erros
        } finally {
            // Fechamento manual do recurso (try-with-resources seria melhor)
            if (fw != null) fw.close();
        }
    }
}

