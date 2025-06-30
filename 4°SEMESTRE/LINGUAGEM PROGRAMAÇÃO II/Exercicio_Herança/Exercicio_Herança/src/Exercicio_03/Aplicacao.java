package Exercicio_03;

import javax.swing.JOptionPane;

public class Aplicacao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cont = 5;
		//vendedor
		String [] nomeVendedor = new String [cont];
		float [] salarioVendedor = new float [cont];
		float [] percentualComissaoVendedor = new float [cont];
		//gerente
		String [] nomeGerente = new String [cont];
		float [] salarioGerente = new float [cont];
		String [] departamentoGerente = new String[cont];
		
		
		//vendedor
		for(int i = 0; i < cont; i++) {
			nomeVendedor[i] = JOptionPane.showInputDialog("Nome do Vendedor : ");
			salarioVendedor[i] = Float.parseFloat(JOptionPane.showInputDialog("Salario Vendedor : "));
			percentualComissaoVendedor[i] = Float.parseFloat(JOptionPane.showInputDialog("Percentual Comissão : "));
		}
		
		//gerente
		for(int i = 0; i < cont; i++) {
			nomeGerente[i] = JOptionPane.showInputDialog("Nome do Gerente : ");
			salarioGerente[i] = Float.parseFloat(JOptionPane.showInputDialog("Salario Gerente : "));
			departamentoGerente[i] = JOptionPane.showInputDialog("Departamento Gerente : ");
		}
		
		//vendedor
		for(int i = 0; i < cont; i++) {
			Vendedor vendedor = new Vendedor(nomeVendedor[i], salarioVendedor[i], percentualComissaoVendedor[i]);
			JOptionPane.showMessageDialog(null, vendedor.toString());
		}
		
		for(int i = 0; i < cont; i++) {
			Gerente gerente = new Gerente(nomeGerente[i], salarioGerente[i], departamentoGerente[i]);
			JOptionPane.showMessageDialog(null, gerente.toString());
		}
	}

}
