Algoritmo "semnome"
// Disciplina   : [Linguagem e L�gica de Programa��o]
// Professor   : Antonio Carlos Nicolodi 
// Descri��o   : Aqui voc� descreve o que o programa faz! (fun��o)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 11/04/2024
Var
// Se��o de Declara��es das vari�veis
    vet : vetor[1..20] de inteiro
    i :inteiro
Inicio
// Se��o de Comandos, procedimento, fun��es, operadores, etc...
   para i de 1 at� 20 passo 1 fa�a
       leia(vet[i])
   fimpara


   para i de 1 at� 20 passo 1 fa�a
        se(vet[i] mod 2 = 0) entao
           escreva(vet[i])
        fimse
   fimpara


Fimalgoritmo