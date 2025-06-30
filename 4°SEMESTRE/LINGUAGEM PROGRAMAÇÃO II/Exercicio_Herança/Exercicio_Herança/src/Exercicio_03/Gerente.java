package Exercicio_03;

public class Gerente extends Empregado{
	private String Departamento;
	
	

	public Gerente() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Gerente(String nome, float salario,String departamento) {
		super(nome, salario);
		Departamento = departamento;
	}



	public String getDepartamento() {
		return Departamento;
	}

	public void setDepartamento(String departamento) {
		Departamento = departamento;
	}



	@Override
	public String toString() {
		return " Departamento : "+ getDepartamento() + super.toString() + "\n";
	}
	
	
}
