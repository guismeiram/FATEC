Algoritmo "semnome"
// 
//  
// 08. Fa�a um algoritmo que leia a idade de uma pessoa expressa em dias e mostre-a expressa em
//anos, meses e dias.
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 07/03/2024
Var
// Se��o de Declara��es das vari�veis 
    idade, dias, meses :inteiro

Inicio
// Se��o de Comandos, procedimento, fun��es, operadores, etc... 

   escreva("Entre com a sua idade:")
   leia(idade)
   dias <- idade * 364
   meses <- (dias \ 30)
   
   escreval("Dias" , ":" ,dias)
   escreval("Meses" , ":" , meses)
   escreval("Idade" , ":" , idade)
   
Fimalgoritmo