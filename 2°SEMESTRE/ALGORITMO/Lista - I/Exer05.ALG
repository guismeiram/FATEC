Algoritmo "semnome"
// 
//  
// 05. Ler dois valores inteiros para as variáveis A e B e efetuar a troca
//dos valores de forma que a variável A passe a possuir o valor da variável B
 //e a variável B passe a possuir o valor da variável A. Apresentar os valores trocados.
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
     
     escreval("o valor é num1"," : ", num1 )
     escreval("o valor é num2", " : ", num2 )


Fimalgoritmo