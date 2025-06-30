package Exercicio_Entrega;

public class Pessoa{
	public int rg;
	public String nome;

	//Construtor padrão sem parametro
	//Sobrecarga
	public Pessoa(){
	}

	//Construtor Com parametro String nome
	//
	public Pessoa(String nome){
		this.nome = nome;
	}

	//Construtor com parametro int rg e String nome 
	
	public Pessoa(int rg, String nome){
		this.rg = rg;
		this.nome = nome;
	}
}
