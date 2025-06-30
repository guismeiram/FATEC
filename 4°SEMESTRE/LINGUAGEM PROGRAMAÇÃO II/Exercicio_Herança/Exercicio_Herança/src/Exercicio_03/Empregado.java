package Exercicio_03;

public class Empregado {
	private String nome;
	protected float salario;
	
	
	
	public Empregado() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Empregado(String nome, float salario) {
		super();
		this.nome = nome;
		this.salario = salario;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}


	@Override
	public String toString() {
		return "Nome empregado : " + getNome() + "\n" + 
				"Salario : " + getSalario() + "\n";
	}
	
	
	
}
