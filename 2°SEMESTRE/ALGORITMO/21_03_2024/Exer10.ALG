Algoritmo "semnome"
// 
//  
// Descrição   : Aqui você descreve o que o programa faz! (função)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 21/03/2024
Var
// Se??o de Declara??es das vari?veis
   n, soma: real

Inicio
// Se??o de Comandos, procedimento, fun??es, operadores, etc...
   soma <- 0
   n <- 1

   enquanto n > 0 faça
       escreva("Digite um numero: ")
       leia(n)

       se ( n > 0 ) entao
          soma <- soma + n
       fimse
   fimenquanto

   escreval("Soma total = ", soma)

Fimalgoritmo