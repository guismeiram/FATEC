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

       para i de 1 ate 3 passo 1 faca
            para j de 1 ate 3 passo 1 faca
                   leia(matrixB[i,j])
            fimpara
       fimpara
       
         para i de 1 ate 3 passo 1 faca
            para j de 1 ate 3 passo 1 faca
                   escreva("---------------------------------------------------")
            fimpara
       fimpara
       
        para i de 1 ate 3 passo 1 faca
            para j de 1 ate 3 passo 1 faca
                 se (i = j ) ent�o
                     soma <- matrixA[i, j] + matrixB[i, j]
                     escreval(soma)
                 senao
                      soma <- matrixA[i, j] + matrixB[i, j]
                      escreval(soma)
                 fimse
            fimpara
       fimpara
       
       para i de 1 ate 3 passo 1 faca
            para j de 1 ate 3 passo 1 faca
                   escreva("---------------------------------------------------")
            fimpara
       fimpara
       
       para i de 1 ate 3 passo 1 faca
            para j de 1 ate 3 passo 1 faca
                   escreval(matrixA[i,j])
            fimpara
       fimpara
       
       para i de 1 ate 3 passo 1 faca
            para j de 1 ate 3 passo 1 faca
                   escreva("---------------------------------------------------")
            fimpara
       fimpara

       para i de 1 ate 3 passo 1 faca
            para j de 1 ate 3 passo 1 faca
                   escreval(matrixB[i,j])
            fimpara
       fimpara
       
       
Fimalgoritmo