package Exercicio_Entrega;

import javax.swing.JOptionPane;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nome = JOptionPane.showInputDialog("Entre com o Nome : ");
		int rg = Integer.parseInt(JOptionPane.showInputDialog("Entre como RG : "));
				
		Pessoa pessoa = new Pessoa(rg, nome);
		System.out.println("RG : " + pessoa.rg + "\n" + "NOME : " + pessoa.nome);
		
		Pessoa pessoa2 = new Pessoa(nome);
		System.out.println(pessoa2.nome);
	}

}
