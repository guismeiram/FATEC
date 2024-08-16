package Aula02;

import java.util.Arrays;

public class Aula02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10;
		Integer aa = 10;
		
		double d = 10.4;
		Double dd = 11.77;
		
		float c = 10.4f;
		float cc = 20.5f;
		
		char s = 'x';
		String ss = "dssss";
		
		char ca1 = '3';
		String ca2 = "33344";
		
		char c1 = '3';
		char c2 = '4';
		
		String s1 = "texto";
		String s2 = "texto2";
		
		System.out.println(a + aa);
		System.out.println(d + dd);
		System.out.println(c + cc);
		System.out.println(s + ss);
		System.out.println(ca1 + ca2);

		if(c1 == c2) {
			System.out.println("Char iguais");
		}else {
			System.out.println("Char diferente");

		}
		
		
		if(s1.equals(s2)) {
			System.out.println("iguais");

		}else {
			System.out.println("diferente");
		}
		
		double r = Math.random();
		System.out.println(r);
		
		double d1 = Math.sqrt(49);
		System.out.println(d1);
		
		int [] a1 = new int [5];
		int a2[];
		a2 = new int [5];
		int a3 [] = {1,2,3,4,5};
		
		a1[0] = 10;
		a1[1] = 20;
		a1[2] = 30;
		a1[3] = 40;
		a1[4] = 50;

		a2[0] = 10;
		a2[1] = 20;
		a2[2] = 30;
		a2[3] = 40;
		a2[4] = 50;
		
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(Arrays.toString(a1));
		System.out.println(Arrays.toString(a2));
		System.out.println(Arrays.toString(a3));


		if(a1 != a2) {
			System.out.println("iguais");
		}else {
			System.out.println("diferentes");

		}
		
		if(a1.equals(a2)) {
			System.out.println("iguais");
		}else {
			System.out.println("diferentes");

		}
		
		System.out.println("Metodo a1: " + soma(a1));
		
	}
	
	public static String soma(int x[]) {
		String s= "";
		int valor = 0;
		for(int i = 0; i < x.length; i++) {
			valor = valor + x[i];
		}
		
		s = String.valueOf(valor);
		return s;
	}

}
