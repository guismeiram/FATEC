class Relatorio {  
    // Método que viola o Open/Closed Principle (OCP) - precisa ser modificado para adicionar novos formatos
    void gerarRelatorio(String tipo) {  
        if (tipo.equals("PDF")) {  
            // Lógica complexa de PDF (alta coesão dentro do método)
        } else if (tipo.equals("HTML")) {  
            // Lógica complexa de HTML (mistura de responsabilidades)
        }  
    }  

    // Método que viola o Single Responsibility Principle (SRP) - classe tem mais de uma responsabilidade
    void salvarNoBanco() {  
        // Lógica de BD (deveria estar em outra classe)
    }  
}

____________________________________________________


// Strategy Pattern - Solução para o problema anterior
interface FormatoRelatorio {  
    void gerar();  // Contrato comum para todos os formatos
}  

// Implementações concretas (fechadas para modificação, abertas para extensão)
class PDF implements FormatoRelatorio { /*...*/ }  
class HTML implements FormatoRelatorio { /*...*/ }  

// SRP aplicado - Classe com única responsabilidade
class RelatorioService {  
    private RelatorioRepository repository;  // Injeção de dependência

    // Método que delega a geração para a estratégia
    void gerar(FormatoRelatorio formato) {  
        formato.gerar();  // Polimorfismo em ação
    }  
}

____________________________________________________


public class DatabaseConnection {  
    private static DatabaseConnection instance;  // Singleton instance

    // Construtor privado previne instanciação externa
    private DatabaseConnection() {}  

    // Método público para acesso controlado à instância única
    public static synchronized DatabaseConnection getInstance() {  
        if (instance == null) {  
            instance = new DatabaseConnection();  // Lazy initialization
        }  
        return instance;  
    }  
}

____________________________________________________


public class DocumentoFactory {  
    // Factory Method - encapsula a lógica de criação de objetos
    public static Documento criarDocumento(String tipo) {  
        return switch (tipo) {  // Switch expression (Java 14+)
            case "PDF" -> new PDF();    // Cria PDF
            case "DOCX" -> new Docx(); // Cria DOCX
            default -> throw new IllegalArgumentException("Formato inválido");  
        };  
    }  
}

____________________________________________________

class CalculadoraImposto {  
    // Método que viola OCP - precisa ser alterado para novos impostos
    double calcular(String tipo, double valor) {  
        if (tipo.equals("ICMS")) {  
            return valor * 0.10;  // Lógica específica
        } else if (tipo.equals("ISS")) {  
            return valor * 0.05;  // Outra lógica específica
        }  
        return 0;  // Comportamento default
    }  
}

____________________________________________________

// Strategy Pattern aplicado a impostos
interface ImpostoStrategy {  
    double calcular(double valor);  // Contrato comum
}  

// Implementações concretas (cada imposto tem sua própria regra)
class ICMS implements ImpostoStrategy { /*...*/ }  
class ISS implements ImpostoStrategy { /*...*/ }  

// Classe que delega o cálculo para as estratégias
class CalculadoraImposto {  
    double calcular(ImpostoStrategy imposto, double valor) {  
        return imposto.calcular(valor);  // Polimorfismo
    }  
}

____________________________________________________


