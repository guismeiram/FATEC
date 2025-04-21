package Exercicio_01;

import javax.swing.JOptionPane;

public class Aplicacao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int x = 5;
		
		String nome [] = new String [x];
		double notaMat [] = new double [x];
		double notaFis [] = new double [x];
		
		
		for(int i = 0; i < x; i++) {
			nome[i] = JOptionPane.showInputDialog("Entre com o nome: ");
			notaMat[i] = Double.parseDouble(JOptionPane.showInputDialog("Entre com a nota de Matematica: "));
			notaFis[i] = Double.parseDouble(JOptionPane.showInputDialog("Entre com a nota de Fisica"));
		}
	


		for(int i = 0; i< x; i++) {
			Aluno aluno = new Aluno(nome[i], notaMat[i], notaFis[i]);
			
			System.out.println("Nome : " + aluno.nome + "\n" + "Nota Matematica : " +aluno.notaMat + "\n" + "Nome Fisica : " + aluno.notaFis + "\n" + "Media : " + aluno.media);
		}

	}

}
