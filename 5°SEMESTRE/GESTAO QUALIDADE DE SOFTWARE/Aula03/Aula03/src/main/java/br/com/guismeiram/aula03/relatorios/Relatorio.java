package br.com.guismeiram.aula03.relatorios;

import br.com.guismeiram.aula03.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class Relatorio {
    public static void gerar(List<Cliente> c) {
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

    public static void main(String[] args) {
        // Criando uma lista de clientes para teste
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(25, "João Silva"));
        clientes.add(new Cliente(17, "Maria Santos"));
        clientes.add(new Cliente(30, "Pedro Costa"));
        clientes.add(new Cliente(16, "Ana Oliveira"));
        clientes.add(new Cliente(19, "Carlos Pereira"));
        clientes.add(new Cliente(15, "Juliana Almeida"));
        clientes.add(new Cliente(22, "Ricardo Nunes"));

        // Criando instância da classe RelatorioClientes

        System.out.println("=== CLIENTES MAIORES DE IDADE ===");
        gerar(clientes);
    }
}
