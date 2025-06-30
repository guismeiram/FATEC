package Exercicio_02;

import java.util.Date;

import javax.swing.JOptionPane;

public class Funcionario {
	private String nome;
	private String dataNascimento;
	private String cpf;
	private double salario;
	
	public Funcionario() {
		super();
		// TODO Auto-generated constructor stub
		
	}
	
	
	
	public Funcionario(String nome, String dataNascimento, String cpf, double salario) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.salario = salario;
	}



	public void exibe() {
		String result = "";
		
		result += "Nome : " + getNome() + "\n";
		result += "Data de Nascimento : " + getDataNascimento() + "\n";
		result += "CPF : " + getCpf() + "\n";
		result += "Salario : " + getSalario() + "\n";
		
		JOptionPane.showMessageDialog(null, result);
	}


	public String getNome() {
		return nome;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public String getCpf() {
		return cpf;
	}
	public double getSalario() {
		return salario;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	
}
