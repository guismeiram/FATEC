package Exercicio_02;

import javax.swing.JOptionPane;

public class Programador extends Funcionario{
	
	private String graduacao;
	private String certificacaoJava;
	private String sexo;
	
	
	
	
	public Programador(String nome, String dataNascimento, String cpf, double salario, String graduacao, String certificacaoJava, String sexo) {
		super(nome, dataNascimento, cpf, salario);
		this.graduacao = graduacao;
		this.certificacaoJava = certificacaoJava;
		this.sexo = sexo;
	}


	public Programador() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public void exibe() {
		String result = "";
		
		result += "Nome : " + super.getNome() + "\n";
		result += "Data de Nascimento : " + super.getDataNascimento() + "\n";
		result += "CPF : " + super.getCpf() + "\n";
		result += "Salario : " + super.getSalario() + "\n";
		result += "Graduação : " + getGraduacao() + "\n";
		result += "Certificação Java" + getCertificacaoJava() + "\n";
		result += "Sexo : " + getSexo() + "\n";
		
		JOptionPane.showMessageDialog(null, result);
	}
	
	
	public String getGraduacao() {
		return graduacao;
	}
	public String getCertificacaoJava() {
		return certificacaoJava;
	}
	public String getSexo() {
		return sexo;
	}
	
	public void setGraduacao(String graduacao) {
		this.graduacao = graduacao;
	}
	public void setCertificacaoJava(String certificacaoJava) {
		this.certificacaoJava = certificacaoJava;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	
}
