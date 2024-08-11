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
	/*Exercício 2: Crie um método que recebe um array de inteiros a e um valor 
	 * inteiro x e retorna a quantidade de vezes que x aparece no array a.*/
	public static int Exercicio02(int vet[], int num) {
		
		int cont = 0;
		
		for(int i = 0; i < vet.length; i++) {
			if(vet[i] == num) {
				cont++;
			}
		}
		
		return cont;
	}
	
	/*Exercício 3: Escreva um método que recebe um array de inteiros a e 
	 * devolve um array de boolean onde, cada posição indique true se o 
	 * elemento da posição correspondente de a é positivo e false caso
	 *  seja negativo ou zero.*/
	public static boolean Exercicio03(int vet[]) {
		
		for(int i = 0; i < vet.length; i++) {
			//for(int j = 0; j < vet.length; j++){
				//if(vet[i] < 0 && vet[j] < 0) {
				if(vet[i] > 0) {
					return true;
				}else {
					return false;
				}
			}
		//}
		
		return false;
	}
	
	/*Exercício 4: Escreva um método que recebe um array de números e devolve
	 *  a posição onde se encontra o maior valor do array. Se houver mais de 
	 *  um valor maior, devolver a posição da primeira ocorrência.
	 */
	public static int Exercicio04(int vet[]) {
		
		int cont = 0;
		
		for(int i = 0; i < vet.length; i++){
			for(int j = 0; j < vet.length; j++){
				if(vet[i] < vet[j]){
					cont++;
				}
			}
		}
		
		return cont;
	}
	/*Exercício 5: Crie um método que recebe um array de inteiros positivos 
	 * e substitui seus elementos de valor ímpar por -1 e os pares por +1*/
	public static int Exercicio05(int vet[]) {
		
		for(int i = 0; i < vet.length; i++){
			if(vet[i] % 2 == 0) {
				return 1;
			}else {
				return -1;
			}
		}
		
		return 1;
	}
	
	public static int retornaMenorElemento(int vetor[], int tamanho){
		int var = Integer.MAX_VALUE;
		int menor = -1;
		
		for (int elemento : vetor) {
			if(elemento < var){
				menor = elemento;
				var = elemento;
			}
		}
		
		return menor;
	}
}
