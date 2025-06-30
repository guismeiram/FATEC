package Exer_02;

import javax.swing.JOptionPane;

public class Aplicacao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Funcionario func = new Funcionario();
		
		func.cpf = JOptionPane.showInputDialog("Entre como CPF : ");
		func.nivelEmp = JOptionPane.showInputDialog("Entre com nivel operacional");
		
		func.nivelEmp = func.nivelEmp.trim().toUpperCase();
		
		String aux = "\n Calculo de PL \n";
		
		if("OURO^PRATA^BRONZE".contains(func.nivelEmp)){
			aux += "Funcionario : " + func.cpf + "\n";
			aux += "Valor PL: R$ " + func.CalcularPL(1320) + "\n";
			aux += "Nivel emp: " + func.nivelEmp + "\n";
		}else {
			aux += "Funcionario: " + func.cpf;
			aux += "Valor PL: R$ " + func.CalcularPL(1320, func.nivelEmp);
			aux += "Nivel emp: "   + func.nivelEmp;
		}
		
		System.out.println(aux);
		
		
	}

}
