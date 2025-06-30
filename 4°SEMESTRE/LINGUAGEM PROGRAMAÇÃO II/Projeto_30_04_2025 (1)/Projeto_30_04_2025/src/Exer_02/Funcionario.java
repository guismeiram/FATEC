package Exer_02;

public class Funcionario {
	public String cpf;
	public String nivelEmp;
	
	public String DescobreNivelEmpresarial(int ano) {
		int anoAtual = 2025;
		int qtAnos = anoAtual - ano;
		
		if(qtAnos < 5) {
			this.nivelEmp = "Bronze";
		}else if(qtAnos >= 5 && qtAnos <= 15) {
			this.nivelEmp = "PRATA";
		}else {
			this.nivelEmp = "OURO";
		}
		
		return this.nivelEmp;
	}
	
	public double CalcularPL(double SalBruto) {
		switch(this.nivelEmp.trim()){
			case "OURO":
				return (SalBruto *5);
			case "PRATA":
				return (SalBruto * 3);
			case "BRONZE":
				return (SalBruto * 2);
			default:
				return 0;
		}
	}
	
	public double CalcularPL(double SalBruto, String anoAdmissao) {
		
		this.nivelEmp = DescobreNivelEmpresarial(Integer.parseInt(anoAdmissao));
		
		switch(this.nivelEmp) {
			case "OURO":
				return (SalBruto *5);
			case "PRATA":
				return (SalBruto * 3);
			case "BRONZE":
				return (SalBruto * 2);
			default:
				return 0;
		}
	}
}
