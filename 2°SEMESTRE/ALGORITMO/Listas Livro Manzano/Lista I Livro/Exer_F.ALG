Algoritmo "semnome"
// Disciplina   : [Linguagem e L�gica de Programa��o] 
// Professor   : Antonio Carlos Nicolodi 
// 
//  
// Descri��o   : Aqui voc� descreve o que o programa faz! (fun��o)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 24/03/2024
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

     escreval("o valor ? num1"," : ", num1 )
     escreval("o valor ? num2", " : ", num2 )


Fimalgoritmo