Algoritmo "semnome"
// Disciplina   : [Linguagem e Lógica de Programação]
// Professor   : Antonio Carlos Nicolodi 
// Descrição   : Aqui você descreve o que o programa faz! (função)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 30/03/2024
Var
// Seção de Declarações das variáveis 
   idade, i, cont, j : inteiro

Inicio
// Seção de Comandos, procedimento, funções, operadores, etc... 
     para i de 1 até 75 passo 1 faça
            leia(idade)
            se( idade >= 18) entao
                cont <- cont + 1
                escreval("Maior de idade : ", idade)
            senao
                 j <- j + 1
                 escreval("Menor de idade : ", idade)
            fimse
     fimpara

     escreval("Quantidade de pessoas maiores de idade : ", cont)
     escreval("Quantidade de pessoas maiores de idade : ", j)
Fimalgoritmo