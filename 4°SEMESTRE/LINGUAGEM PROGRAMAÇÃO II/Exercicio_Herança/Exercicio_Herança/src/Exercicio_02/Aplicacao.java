package Exercicio_02;

import javax.swing.JOptionPane;

public class Aplicacao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cont = 5;
		
		
		//Analista
		String Mestrado [] = new String [cont];
		String experiencia [] = new String [cont];
		String [] nomeAnalista = new String [cont];
		String [] dataNascimentoAnalista = new String [cont];
		String cpfAnalista [] = new String [cont];
		double salarioAnalista [] = new double [cont];
		
		//Programador
		String graduacao [] = new String[cont];
	    String certificacaoJava [] = new String[cont];
		String sexo [] = new String [cont];
		String [] nomeProgramador = new String [cont];
		String [] dataNascimentoProgramador = new String [cont];
		String cpfProgramador [] = new String [cont];
		double salarioProgramdor [] = new double [cont];
		
		//Analista
		for(int i = 0; i < cont; i++) {
		
			nomeAnalista[i] = JOptionPane.showInputDialog("Qual é o seu nome?");
			dataNascimentoAnalista[i] = JOptionPane.showInputDialog("Entre com a sua data de nascimento");
			cpfAnalista[i] = JOptionPane.showInputDialog("Entre com seu CPF");
			salarioAnalista[i] = Double.parseDouble(JOptionPane.showInputDialog("Entre com o seu salario"));
			Mestrado[i] = JOptionPane.showInputDialog("Você tem mestrado ?");
			experiencia[i] = JOptionPane.showInputDialog("Entre com a quantidade de meses de experiencia : ");
			
		}
			
		
		//Programador
		for(int i = 0; i < cont; i++) {
			
			nomeProgramador[i] = JOptionPane.showInputDialog("Qual é o seu nome?");
			dataNascimentoProgramador[i] = JOptionPane.showInputDialog("Entre com a sua data de nascimento");
			cpfProgramador[i] = JOptionPane.showInputDialog("Entre com seu CPF");
			salarioProgramdor[i] = Double.parseDouble(JOptionPane.showInputDialog("Entre com o seu salario"));
			graduacao[i] = JOptionPane.showInputDialog("Você tem graduação ?");
			certificacaoJava[i] = JOptionPane.showInputDialog("Você tem Certificação Java ?");
			sexo[i] = JOptionPane.showInputDialog("Entre com a quantidade de meses de experiencia : ");
			
		}
		
		//Analista
		for(int i = 0; i < cont; i++) {
			Analista analista  = new Analista(nomeAnalista[i], dataNascimentoAnalista[i], cpfAnalista[i], salarioAnalista[i], Mestrado[i], experiencia[i]);
			analista.exibe();
		}
		
		//Programador
		for(int i = 0; i < cont; i++) {
			Programador programador = new Programador(nomeProgramador[i], dataNascimentoProgramador[i], cpfProgramador[i], salarioProgramdor[i], graduacao[i], certificacaoJava[i], sexo[i]);
			programador.exibe();

		}
		

		
		
		
	}
}
