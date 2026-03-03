package br.com.guismeiram.aula05.Exer01;

import java.io.FileWriter;
import java.io.IOException;

public class CadastroUsuario {
    // Método com validação simples (poderia usar exceções)
    void cadastrar(String nome, int idade) {
        if (idade < 18) {
            // Uso de System.err (não recomendado para produção)
            System.err.println("Usuário menor de idade");
        }
        // ...
    }

    // Método com manipulação de arquivo (antipatterns)
    void salvarArquivo(String path) throws IOException {
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
