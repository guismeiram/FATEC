/**
 * Calculadora de operações financeiras básicas.
 * @author Douglas Duarte
 * @version 1.1
 */
public class Financeira {
    
    /**
     * Calcula juros compostos.
     * @param principal Valor inicial
     * @param taxa Taxa mensal (0.1 = 10%)
     * @param meses Período
     * @return Valor futuro
     * @throws IllegalArgumentException Se taxa ou meses forem negativos
     */
    public double jurosCompostos(double principal, double taxa, int meses) {
        if (taxa < 0 || meses < 0) {
            throw new IllegalArgumentException("Parâmetros não podem ser negativos");
        }
        return principal * Math.pow(1 + taxa, meses);
    }
}

____________________________________________________________________

mvn javadoc:javadoc
# Acesse: target/site/apidocs/index.html
____________________________________________________________________

<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-ui</artifactId>
    <version>1.7.0</version>
</dependency>

____________________________________________________________________

@Operation(summary = "Obter usuário por ID")
@ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Usuário encontrado"),
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
})
@GetMapping("/usuarios/{id}")
public Usuario getUsuario(@Parameter(description = "ID do usuário") @PathVariable Long id) {
    return service.findById(id);
}

____________________________________________________________________

# Sistema de Pagamentos  

## Requisitos  
- Java 17+  
- PostgreSQL 14  

## Como Executar  
```bash 
mvn spring-boot:run


## Rotas Principais  
| Endpoint       | Método | Descrição          |  
|----------------|--------|--------------------|  
| `/pagamentos`  | POST   | Cria novo pagamento|  

**Vantagens:**
- Formato universal (GitHub, GitLab, etc.)
- Sintaxe simples
- Tabelas para organizar informações
- Destaque de código

### 6. Documentação em Confluence (Exemplo)

h2. Visão Geral  
*Data de Criação*: {{data}}  
*Responsável*: {{owner}}  

h3. Fluxo Principal  
{code:java}  
public void processar() { ... }  
{code}  

h3. Decision Records  
||Data||Decisão||Razão||  
|12/05|Usar JWT|Mais stateless|  

____________________________________________________________________

**Características:**
- Sintaxe específica do Confluence
- Modelo padronizado
- Registro de decisões arquiteturais
- Inclusão de snippets de código

### Tipos de Documentação Demonstrados:

1. **Documentação de Código** (JavaDoc)
   - Embedded no código-fonte
   - Específica para desenvolvedores
   - Geração automática

2. **Documentação de API** (OpenAPI/Swagger)
   - Interativa
   - Focada em consumidores da API
   - Atualização automática

3. **Documentação de Projeto** (Markdown)
   - Instruções de setup
   - Visão geral
   - Formato portável

4. **Documentação Arquitetural** (Confluence)
   - Decisões técnicas
   - Fluxos do sistema
   - Colaborativa

**Boas Práticas Gerais:**
- Manter documentação próxima do código
- Automatizar geração quando possível
- Usar padrões reconhecidos
- Manter consistência
- Documentar não apenas "o que" mas também "porquê"