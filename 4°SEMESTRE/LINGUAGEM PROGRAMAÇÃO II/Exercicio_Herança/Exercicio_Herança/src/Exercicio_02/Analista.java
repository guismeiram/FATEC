package Exercicio_02;

import javax.swing.JOptionPane;

public class Analista extends Funcionario{
	private String Mestrado;
	private String experiencia;
	
	
	
	public Analista() {
		super();
		// TODO Auto-generated constructor stub
		
	}
	
	
	
	public Analista(String nome, String dataNascimento, String cpf, double salario,String mestrado, String experiencia) {
		super(nome, dataNascimento, cpf, salario);
		this.Mestrado = mestrado;
		this.experiencia = experiencia;
		
	}



	public void exibe() {
		String result = "";
		
		result += "Nome : " + super.getNome() + "\n";
		result += "Data de Nascimento : " + super.getDataNascimento() + "\n";
		result += "CPF : " + super.getCpf() + "\n";
		result += "Salario : " + super.getSalario() + "\n";
		result += "Tem o Mestrado : " + getMestrado() + "\n";
		result += "Tem pode experiencia : "  + getExperiencia() + "\n";
		
		JOptionPane.showMessageDialog(null, result);
	}
	
	public String getMestrado() {
		return Mestrado;
	}
	public String getExperiencia() {
		return experiencia;
	}
	public void setMestrado(String mestrado) {
		Mestrado = mestrado;
	}
	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}
	
	
}
