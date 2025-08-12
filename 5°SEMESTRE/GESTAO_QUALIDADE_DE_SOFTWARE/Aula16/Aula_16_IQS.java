public class PedidoService {
    public BigDecimal calcularTotal(Pedido pedido, String tipoCliente) {
        BigDecimal total = BigDecimal.ZERO;
        
        // Cálculo dos itens (responsabilidade 1)
        for (ItemPedido item : pedido.getItens()) {
            total = total.add(item.getPreco().multiply(new BigDecimal(item.getQuantidade())));
        }
        
        // Cálculo de descontos (responsabilidade 2) - Problema principal
        switch (tipoCliente) {
            case "VIP":
                total = total.multiply(new BigDecimal("0.9")); // 10% off
                break;
            case "PREMIUM":
                total = total.multiply(new BigDecimal("0.8")); // 20% off
                break;
            // ... mais casos (aberto para modificação)
        }
        
        // Cálculo de frete (responsabilidade 3)
        if (total.compareTo(new BigDecimal("100")) < 0) {
            total = total.add(new BigDecimal("15")); // Frete fixo
        }
        
        return total;
    }
}

_________________________________________________________________________

public interface PoliticaDesconto {
    BigDecimal aplicarDesconto(BigDecimal total);
}

// Implementação concreta para VIP
public class DescontoVIP implements PoliticaDesconto {
    public BigDecimal aplicarDesconto(BigDecimal total) {
        return total.multiply(new BigDecimal("0.9")); // 10% de desconto
    }
}

_________________________________________________________________________

public class PedidoService {
    private final PoliticaDesconto descontoStrategy;
    private final CalculadoraFrete calculadoraFrete;

    // Injeção via construtor (Dependency Injection)
    public PedidoService(PoliticaDesconto strategy, CalculadoraFrete frete) {
        this.descontoStrategy = strategy;
        this.calculadoraFrete = frete;
    }

    public BigDecimal calcularTotal(Pedido pedido) {
        // Cálculo dos itens (Stream API)
        BigDecimal total = pedido.getItens().stream()
            .map(item -> item.getPreco().multiply(BigDecimal.valueOf(item.getQuantidade())))
            .reduce(BigDecimal.ZERO, BigDecimal::add);
        
        total = descontoStrategy.aplicarDesconto(total); // Delega o desconto
        return calculadoraFrete.calcular(total); // Delega o frete
    }
}
_________________________________________________________________________

class PedidoServiceTest {
    @Test
    void deveCalcularTotalComDescontoVIP() {
        // 1. Arrange (Preparação)
        PoliticaDesconto strategy = new DescontoVIP();
        CalculadoraFrete freteMock = mock(CalculadoraFrete.class);
        when(freteMock.calcular(any())).thenReturn(new BigDecimal("90"));
        
        PedidoService service = new PedidoService(strategy, freteMock);
        Pedido pedido = new Pedido(List.of(new ItemPedido(new BigDecimal("100"), 1)));
        
        // 2. Act (Execução)
        BigDecimal resultado = service.calcularTotal(pedido);
        
        // 3. Assert (Verificação)
        assertEquals(new BigDecimal("90"), resultado);
    }
}

_________________________________________________________________________


mvn sonar:sonar  # Executa análise estática de código

_________________________________________________________________________

## Decisão 2024-05-20  
**Padrão:** Strategy  
**Motivo:** Remover switch statement complexo  
**Arquivos alterados:**  
- PedidoService.java  
- PoliticaDesconto.java  