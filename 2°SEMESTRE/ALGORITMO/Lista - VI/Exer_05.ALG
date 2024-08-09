Algoritmo "semnome"
// Disciplina   : [Linguagem e Lógica de Programação]
// Professor   : Antonio Carlos Nicolodi 
// Descrição   : Aqui você descreve o que o programa faz! (função)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 01/05/2024
Var
// Seção de Declarações das variáveis
      matrixA :vetor[1..2, 1..2] de inteiro
      matrixB :vetor[1..2, 1..2] de inteiro
      i, j, fat, sub, cont: inteiro

Inicio
// Seção de Comandos, procedimento, funções, operadores, etc...
       fat <- 1
       sub <- 1

       para i de 1 ate 2 passo 1 faca
            para j de 1 ate 2 passo 1 faca
                   leia(matrixA[i,j])
            fimpara
       fimpara

        //soma <- i + j

        para i de 1 ate 2 passo 1 faça
           para j de 1 ate 2 passo 1 faça
                 enquanto matrixA[i,j] > cont faca
                      escreval("Fatorial de cada numero da matriz", fat)
                      cont <- cont + 1
                      fat <- fat + (matrixA[i,j] * cont)
                 fimenquanto
            fimpara
       fimpara

       //enquanto matrixA[i,j] <= cont  faca
                 //cont <- cont + 1
                 //fat <- fat + (matrixA[i,j] * cont)
                 //escreval(fat)
       //fimenquanto
       
       

       //para i de 1 ate 2 passo 1 faca
           // para j de 1 ate 2 passo 1 faca
               // escreval(fat)
            //fimpara
       //fimpara

Fimalgoritmo