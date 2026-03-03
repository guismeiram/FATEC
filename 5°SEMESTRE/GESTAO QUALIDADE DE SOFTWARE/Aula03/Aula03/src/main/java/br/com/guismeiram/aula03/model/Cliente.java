package br.com.guismeiram.aula03.model;

public class Cliente {

    private int  idade;
    private String nome;

    public Cliente() {
    }
    public Cliente(int idade, String nome) {
        this.idade = idade;
        this.nome = nome;
    }


    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
