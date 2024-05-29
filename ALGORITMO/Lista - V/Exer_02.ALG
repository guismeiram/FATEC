Algoritmo "semnome"
// Disciplina   : [Linguagem e Lógica de Programação]
// Professor   : Antonio Carlos Nicolodi 
// Descrição   : Aqui você descreve o que o programa faz! (função)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 11/04/2024
Var
// Seção de Declarações das variáveis
    vet : vetor[1..20] de inteiro
    i :inteiro
Inicio
// Seção de Comandos, procedimento, funções, operadores, etc...
   para i de 1 até 20 passo 1 faça
       leia(vet[i])
   fimpara


   para i de 1 até 20 passo 1 faça
        se(vet[i] mod 2 = 0) entao
           escreva(vet[i])
        fimse
   fimpara


Fimalgoritmo