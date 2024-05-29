Algoritmo "semnome"
// 
//  
// 13. Elaborar um programa que efetue a apresentação do valor da conversão
//em real de um valor lido em dólar. O programa deve solicitar o valor da cotação
// do dólar e também a quantidade de dólares disponível com o usuário, para que
//  seja apresentado o valor em moeda brasileira.
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 08/03/2024
Var
// Seção de Declarações das variáveis 
   cotacao1, valor1: real

Inicio
// Seção de Comandos, procedimento, funções, operadores, etc... 

   escreva("Entre com a Cotação : ")
   leia(cotacao1)
   
   escreva("Entre com o valor do dinheiro :")
   leia(valor1)
   
   escreval("Valor do dinheiro convertido de dolar para real", " : ", valor1 * cotacao1)

Fimalgoritmo