Algoritmo "semnome"
// 
//  
// 13. Elaborar um programa que efetue a apresenta��o do valor da convers�o
//em real de um valor lido em d�lar. O programa deve solicitar o valor da cota��o
// do d�lar e tamb�m a quantidade de d�lares dispon�vel com o usu�rio, para que
//  seja apresentado o valor em moeda brasileira.
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 08/03/2024
Var
// Se��o de Declara��es das vari�veis 
   cotacao1, valor1: real

Inicio
// Se��o de Comandos, procedimento, fun��es, operadores, etc... 

   escreva("Entre com a Cota��o : ")
   leia(cotacao1)
   
   escreva("Entre com o valor do dinheiro :")
   leia(valor1)
   
   escreval("Valor do dinheiro convertido de dolar para real", " : ", valor1 * cotacao1)

Fimalgoritmo