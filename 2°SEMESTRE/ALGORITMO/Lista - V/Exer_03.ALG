Algoritmo "semnome"
// Disciplina   : [Linguagem e Lógica de Programação]
// Professor   : Antonio Carlos Nicolodi 
// Descrição   : Aqui você descreve o que o programa faz! (função)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 11/04/2024
Var
// Seção de Declarações das variáveis 
      i, cont : inteiro
      vetA : vetor[1..10] de inteiro
      vetB : vetor[1..10] de inteiro
Inicio
// Seção de Comandos, procedimento, funções, operadores, etc... 
     i <- 1
     cont <- 1
     
     para i de 1 até 10 passo 1 faça
       leia(vetA[i])
     fimpara
     
     para i de 1 ate 10 passo 1 faça
         vetB[i] <- vetA[i] * 2
     fimpara

     para i de 1 ate 10 passo 1 faça
         escreval(vetB[i])
     fimpara
Fimalgoritmo