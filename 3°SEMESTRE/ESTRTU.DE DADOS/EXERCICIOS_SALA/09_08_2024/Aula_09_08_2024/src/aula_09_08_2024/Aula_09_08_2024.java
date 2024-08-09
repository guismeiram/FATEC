/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula_09_08_2024;

import javax.swing.JOptionPane;

/**
 *
 * @author Aluno
 */
public class Aula_09_08_2024 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int vet [] = new int[10];
        
        for(int i = 0; i < vet.length; i++){
          vet[i] = Integer.parseInt(JOptionPane.showInputDialog("Entre com os valores:"));
        }
        
        Ordenar_Vetor.OrdenaVetor(vet);
        
        for(int i = 0; i < vet.length; i++){
			System.out.println("Ordem crescente: " + vet[i]);
		}
    }
    
}
