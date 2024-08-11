package Exercicios;

import javax.swing.JOptionPane;

public class ListaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int vet [] = new int[5];
		 
	     for(int i = 0; i < vet.length; i++){
	        vet[i] = Integer.parseInt(JOptionPane.showInputDialog("Entre com os valores:"));
	     }
	      
	    int valor = Integer.parseInt(JOptionPane.showInputDialog("Entre com os valores:"));
	        
		System.out.println("Quantidade de numeros negativos:" + " " + Lista.Exercicio01(vet));
		System.out.println("Quantidade de numeros repetidos:" + " " + Lista.Exercicio02(vet, valor));
		
		for(int i = 0; i < vet.length; i++) {
			System.out.println("Quantidade de numeros pares e impar:" + " " + Lista.Exercicio03(vet));
		}

			
	     
	}

}
