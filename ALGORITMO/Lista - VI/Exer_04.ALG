Algoritmo "semnome"
// Disciplina   : [Linguagem e L�gica de Programa��o]
// Professor   : Antonio Carlos Nicolodi 
// Descri��o   : Aqui voc� descreve o que o programa faz! (fun��o)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 01/05/2024
Var
// Se��o de Declara��es das vari�veis
      matrixA :vetor[1..3, 1..3] de inteiro
      matrixB :vetor[1..3, 1..3] de inteiro
      i, j, soma: inteiro

Inicio
// Se��o de Comandos, procedimento, fun��es, operadores, etc...
       para i de 1 ate 3 passo 1 faca
            para j de 1 ate 3 passo 1 faca
                   leia(matrixA[i,j])
            fimpara
       fimpara

        //soma <- i + j

        para i de 1 ate 3 passo 1 faca
            para j de 1 ate 3 passo 1 faca
                 se (i + j = 4) ent�o
                    matrixB[i,j] <- matrixA[i,j]
                 fimse
            fimpara
       fimpara


       para i de 1 ate 3 passo 1 faca
            para j de 1 ate 3 passo 1 faca
                 se (i + j = 4) ent�o
                    escreval(matrixB[i,j])
                 fimse
            fimpara
       fimpara

Fimalgoritmo