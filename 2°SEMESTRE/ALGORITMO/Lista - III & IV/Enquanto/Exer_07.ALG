Algoritmo "semnome"
// Disciplina   : [Linguagem e L�gica de Programa��o]
// Professor   : Antonio Carlos Nicolodi 
// Descri��o   : Aqui voc� descreve o que o programa faz! (fun��o)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 04/04/2024
Var
// Se��o de Declara��es das vari�veis
   valor, i :inteiro

Inicio
// Se��o de Comandos, procedimento, fun��es, operadores, etc...
   leia(valor)
   i <- 1
   enquanto (i < valor) fa�a
            se(i < valor) entao
                 i <- i + 1
                 valor <- valor * i
            fimse
   fimenquanto

   escreval("O Fatorial � : ", valor, i)
Fimalgoritmo