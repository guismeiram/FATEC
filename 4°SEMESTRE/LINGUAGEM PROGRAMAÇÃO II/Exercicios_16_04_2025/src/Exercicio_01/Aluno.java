package Exercicio_01;

public class Aluno {
	public String nome;
	public double notaMat, notaFis, media;
	 
	public Aluno(){
	    System.out.println("Objeto criado");
	}
	public Aluno(String Nome, double NotaMat, double NotaFis){
	    nome=Nome;
	    notaMat=NotaMat;
	    notaFis=NotaFis;
	    media= (notaMat + notaFis)/2;
	}
}
