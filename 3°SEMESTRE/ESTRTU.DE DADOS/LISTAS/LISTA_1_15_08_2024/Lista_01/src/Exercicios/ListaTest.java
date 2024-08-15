package Exercicios;

import javax.swing.JOptionPane;

public class ListaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int vet [] = new int[3];
		 
	     for(int i = 0; i < vet.length; i++){
	        vet[i] = Integer.parseInt(JOptionPane.showInputDialog("Entre com os valores:"));
	     }
	      
	    int valor = Integer.parseInt(JOptionPane.showInputDialog("Entre com os valores:"));
	        
		System.out.println("Quantidade de numeros negativos:" + " " + Lista.Exercicio01(vet));
		System.out.println("Quantidade de numeros repetidos:" + " " + Lista.Exercicio02(vet, valor));
		//Exer03
		boolean[] resultado = Lista.verificaPositivos(vet);

        // Exibe o resultado
        for (boolean b : resultado) {
            System.out.print(b + " "); // Saída: false false true false true
        }
		System.out.println("posição onde se encontra o maior valor do array:" + Lista.Exercicio04(vet));
		Lista.Exercicio05(vet);	
	    
		
	}

}
