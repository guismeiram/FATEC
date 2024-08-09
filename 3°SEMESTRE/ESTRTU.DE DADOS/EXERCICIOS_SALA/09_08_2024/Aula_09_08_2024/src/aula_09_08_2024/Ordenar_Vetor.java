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
public class Ordenar_Vetor {
    
    
    public static void OrdenaVetor(int vet[]){
    	
    	int troca = 0;
    	
    	for(int i = 0; i < vet.length; i++){
			for(int j = 0; j < vet.length; j++){
				if(vet[i] < vet[j]){
					troca = vet[j];
					vet[j] = vet[i];
					vet[i] = troca;
				}
			}
		}
    }   
}
