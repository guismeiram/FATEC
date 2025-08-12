<!-- Configuração do Maven Checkstyle Plugin -->
<plugin>
    <groupId>org.apache.maven.plugins</groupId>  
    <artifactId>maven-checkstyle-plugin</artifactId>  
    <version>3.2.1</version>  
    <configuration>  
        <!-- Define o arquivo de configuração do Checkstyle como o padrão do Google -->
        <configLocation>google_checks.xml</configLocation>  
    </configuration>  
</plugin>

__________________________________________________________________

# Comando Maven para executar a verificação de estilo usando o plugin Checkstyle
mvn checkstyle:check
__________________________________________________________________

// Antes: Método com nome pouco descritivo e parâmetros sem significado
public void calc(int x,int y){...}

// Depois: Refatorado com nome mais significativo e parâmetros descritivos
public void calcularArea(int largura, int altura) {...}
__________________________________________________________________


public class Relatorio {  
    public void gerar(List<Cliente> c) {  
        // Verificação nula tradicional
        if(c != null) {  
            // Loop tradicional com filtro manual
            for(Cliente cli : c) {  
                if(cli.getIdade() > 18) {  
                    System.out.println(cli.getNome());  
                }  
            }  
        }  
    }  
} 

__________________________________________________________________


public class RelatorioClientes {  
    public void imprimirClientesMaioresDeIdade(List<Cliente> clientes) {  
        // Verificação nula com early return (mais limpo)
        if (clientes == null) return;  

        // Uso de Stream API para código mais declarativo e funcional
        clientes.stream()  
               .filter(cliente -> cliente.getIdade() > 18)  
               .forEach(cliente -> System.out.println(cliente.getNome()));  
    }  
}
__________________________________________________________________

class Pagamento {  
    void processar(String t, double v) {  
        // Condicional complexa que viola o princípio Open/Closed
        if(t.equals("CREDITO")) {  
            // 20 linhas de código (indica possível violação do Single Responsibility)
        } else if(t.equals("BOLETO")) {  
            // 15 linhas de código (sugere que deveria ser uma classe separada)
        }  
    }  
}

__________________________________________________________________

