Algoritmo "semnome"
// Disciplina   : [Linguagem e Lógica de Programação]
// Professor   : Antonio Carlos Nicolodi 
// Descrição   : Aqui você descreve o que o programa faz! (função)
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

   Se B < A Então
      temp <- A
      A <- B
      B <- temp
   FimSe

   Se C < A Então
      temp <- A
      A <- C
      C <- temp
   FimSe

   Se C < B Então
      temp <- B
      B <- C
      C <- temp
   FimSe

   Escreva("Após a troca, A =", A)
   Escreva("Após a troca, B =", B)
   Escreva("Após a troca, C =", C)

FimAlgoritmo