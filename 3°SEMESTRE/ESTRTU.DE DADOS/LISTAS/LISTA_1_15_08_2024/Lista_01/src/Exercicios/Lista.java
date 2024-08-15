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
	public static boolean[] verificaPositivos(int[] vet) {
        boolean[] resultado = new boolean[vet.length];

        for (int i = 0; i < vet.length; i++) {
            resultado[i] = vet[i] > 0;
        }

        return resultado;
    }
	
	/*Exercício 4: Escreva um método que recebe um array de números e devolve
	 *  a posição onde se encontra o maior valor do array. Se houver mais de 
	 *  um valor maior, devolver a posição da primeira ocorrência.
	 */
	public static int Exercicio04(int vet[]) {
		
		int num = Integer.MIN_VALUE;
		int menor = -1, cont = 0;
		
		for (int elemento : vet) {
			if(elemento > num){
				menor = elemento;
				num = elemento;
				cont++;
			}
		}
		
		return cont;
	}
	
	/*Exercício 5: Crie um método que recebe um array de inteiros positivos 
	 * e substitui seus elementos de valor ímpar por -1 e os pares por +1*/
	public static void Exercicio05(int vet[]) {
		int positivo = 1, negativo = -1;
		int recebe = 0;
		
		for(int i = 0; i < vet.length; i++) {
			
			if(vet[i] % 2 == 0) {
				recebe = vet[i];
				recebe = positivo;
				System.out.println("Numero par:" + recebe);
			
			}else {
				recebe = vet[i];
				recebe = negativo;
				System.out.println("Numero impar:" + recebe);

			}
		}
		
	}
	
	
}
