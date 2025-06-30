package Exercicio_03;

public class Vendedor extends Empregado{
	
	private float percentualComissao;
	
	

	public Vendedor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vendedor(String nome, float salario, float percentualComissao) {
		super(nome, salario);
		this.percentualComissao = percentualComissao;
		// TODO Auto-generated constructor stub
	}

	public Vendedor(float percentualComissao) {
		super();
		this.percentualComissao = percentualComissao;
	}

	public float getPercentualComissao() {
		return percentualComissao;
	}

	public void setPercentualComissao(float percentualComissao) {
		this.percentualComissao = percentualComissao;
	}

	@Override
	public String toString() {
		return  " Percentual Comissao :" + getPercentualComissao() + "\n"
				+ "Salario + Comissão : " + calcularSalario() +  "\n"
				+ super.toString() ;
	}
	
	public float calcularSalario() {
		return percentualComissao + super.getSalario();
	}
}
