Algoritmo "semnome"
// 
//  
// 05. Ler dois valores inteiros para as vari�veis A e B e efetuar a troca
//dos valores de forma que a vari�vel A passe a possuir o valor da vari�vel B
 //e a vari�vel B passe a possuir o valor da vari�vel A. Apresentar os valores trocados.
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 07/03/2024
Var
// variaveis
   num1, num2, recebe: real

Inicio
// Se??o de Comandos, procedimento, fun??es, operadores, etc...

     escreva("Informe o primeiro numero: ")
     leia(num1)
     escreva("Informe o segundo numero: ")
     leia(num2)

     recebe <- num1
     num1 <- num2
     num2 <- recebe
     
     escreval("o valor � num1"," : ", num1 )
     escreval("o valor � num2", " : ", num2 )


Fimalgoritmo