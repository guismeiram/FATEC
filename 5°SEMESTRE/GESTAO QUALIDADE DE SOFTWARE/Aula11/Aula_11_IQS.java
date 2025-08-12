# Executa o SonarQube em um container Docker
docker run -d --name sonarqube -p 9000:9000 sonarqube:community
________________________________________________________________

<!-- Plugin para integração do SonarQube com Maven -->
<plugin>
    <groupId>org.sonarsource.scanner.maven</groupId>
    <artifactId>sonar-maven-plugin</artifactId>
    <version>3.9.1.2184</version> <!-- Versão específica do plugin -->
</plugin>
________________________________________________________________

# Comando para executar análise no SonarQube
mvn clean verify sonar:sonar \
  -Dsonar.projectKey=meu-projeto \       # Chave única do projeto
  -Dsonar.host.url=http://localhost:9000 \ # URL do SonarQube
  -Dsonar.login=SEU_TOKEN               # Token de autenticação
  
  ________________________________________________________________
  
public class FinanceUtils {
    // Método com complexidade ciclomática elevada (8)
    public BigDecimal calcularImposto(BigDecimal valor, String tipo) {
        if (valor == null) return BigDecimal.ZERO;
        
        if (tipo.equals("ICMS")) {
            return valor.multiply(new BigDecimal("0.17"));
        } else if (tipo.equals("IPI")) {
            if (valor.compareTo(new BigDecimal("10000")) > 0) {
                return valor.multiply(new BigDecimal("0.10"));
            } else {
                return valor.multiply(new BigDecimal("0.05"));
            }
        } // ... mais condições
    }
}

________________________________________________________________

// Interface comum para estratégias de cálculo
public interface ImpostoStrategy {
    BigDecimal calcular(BigDecimal valor);
}

// Implementação concreta para ICMS
public class IcmsStrategy implements ImpostoStrategy {
    public BigDecimal calcular(BigDecimal valor) {
        return valor.multiply(new BigDecimal("0.17"));
    }
}

// Classe principal refatorada
public class FinanceUtils {
    private Map<String, ImpostoStrategy> estrategias;
    
    public FinanceUtils() {
        // Mapeia tipos de imposto para suas estratégias
        this.estrategias = Map.of(
            "ICMS", new IcmsStrategy(),
            "IPI", new IpiStrategy()
        );
    }
    
    // Método simplificado (complexidade = 1)
    public BigDecimal calcularImposto(BigDecimal valor, String tipo) {
        if (valor == null || !estrategias.containsKey(tipo)) {
            return BigDecimal.ZERO;
        }
        return estrategias.get(tipo).calcular(valor);
    }
}

________________________________________________________________

