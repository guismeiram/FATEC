Algoritmo "semnome"
// Disciplina   : [Linguagem e Lógica de Programação]
// Professor   : Antonio Carlos Nicolodi 
// Descrição   : Aqui você descreve o que o programa faz! (função)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 01/05/2024
Var
// Seção de Declarações das variáveis
      matrixA :vetor[1..3, 1..3] de inteiro
      matrixB :vetor[1..3, 1..3] de inteiro
      i, j, soma: inteiro

Inicio
// Seção de Comandos, procedimento, funções, operadores, etc...
       para i de 1 ate 3 passo 1 faca
            para j de 1 ate 3 passo 1 faca
                   leia(matrixA[i,j])
            fimpara
       fimpara

        //soma <- i + j

        para i de 1 ate 3 passo 1 faca
            para j de 1 ate 3 passo 1 faca
                 se (i + j = 4) então
                    matrixB[i,j] <- matrixA[i,j]
                 fimse
            fimpara
       fimpara


       para i de 1 ate 3 passo 1 faca
            para j de 1 ate 3 passo 1 faca
                 se (i + j = 4) então
                    escreval(matrixB[i,j])
                 fimse
            fimpara
       fimpara

Fimalgoritmo