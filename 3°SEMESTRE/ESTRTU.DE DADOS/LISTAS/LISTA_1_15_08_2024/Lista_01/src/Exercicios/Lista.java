package Exercicios;

public class Lista {
	/*Exercício 1: Crie um método que recebe um array de inteiros e retorna a 
	 * quantidade de elementos do array que são números negativos.*/
	
	public static int Exercicio01(int vet[]) {
		
		int cont = 0;
		
		for(int i = 0; i < vet.length; i++) {
			if(vet[i] < 0) {
				cont++;
			}
		}
		
		return cont;
	}
	
	public static int Exercicio02(int vet[], int num) {
		
		int cont = 0;
		
		for(int i = 0; i < vet.length; i++) {
			if(vet[i] == num) {
				cont++;
			}
		}
		
		return cont;
	}
	
	public static boolean Exercicio03(int vet[], boolean positivoOuNegativo) {
		
		for(int i = 0; i < vet.length; i++) {
			if(vet[i] > 0) {
				return true;
			}else {
				return false;
			}
		}
		
		return positivoOuNegativo;
	}
	
	
}
