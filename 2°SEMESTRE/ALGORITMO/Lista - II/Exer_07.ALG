Algoritmo "semnome"
// Disciplina   : [Linguagem e L�gica de Programa��o]
// Professor   : Antonio Carlos Nicolodi 
// Descri��o   : Aqui voc� descreve o que o programa faz! (fun��o)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 28/03/2024
Var
   A, B, C, temp: real

Inicio
   Escreva("Digite o valor de A: ")
   Leia(A)
   Escreva("Digite o valor de B: ")
   Leia(B)
   Escreva("Digite o valor de C: ")
   Leia(C)

   Se B < A Ent�o
      temp <- A
      A <- B
      B <- temp
   FimSe

   Se C < A Ent�o
      temp <- A
      A <- C
      C <- temp
   FimSe

   Se C < B Ent�o
      temp <- B
      B <- C
      C <- temp
   FimSe

   Escreva("Ap�s a troca, A =", A)
   Escreva("Ap�s a troca, B =", B)
   Escreva("Ap�s a troca, C =", C)

FimAlgoritmo