Algoritmo "semnome"
// Disciplina   : [Linguagem e L�gica de Programa��o]
// Professor   : Antonio Carlos Nicolodi 
// Descri��o   : Aqui voc� descreve o que o programa faz! (fun��o)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 11/04/2024
Var
// Se��o de Declara��es das vari�veis 
      i, cont : inteiro
      vetA : vetor[1..10] de inteiro
      vetB : vetor[1..10] de inteiro
Inicio
// Se��o de Comandos, procedimento, fun��es, operadores, etc... 
     i <- 1
     cont <- 1
     
     para i de 1 at� 10 passo 1 fa�a
       leia(vetA[i])
     fimpara
     
     para i de 1 ate 10 passo 1 fa�a
         vetB[i] <- vetA[i] * 2
     fimpara

     para i de 1 ate 10 passo 1 fa�a
         escreval(vetB[i])
     fimpara
Fimalgoritmo