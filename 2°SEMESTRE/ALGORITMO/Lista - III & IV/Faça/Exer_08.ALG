Algoritmo "semnome"
// Disciplina   : [Linguagem e L�gica de Programa��o]
// Professor   : Antonio Carlos Nicolodi 
// Descri��o   : Aqui voc� descreve o que o programa faz! (fun��o)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 30/03/2024
Var
// Se��o de Declara��es das vari�veis 
   idade, i, cont, j : inteiro

Inicio
// Se��o de Comandos, procedimento, fun��es, operadores, etc... 
     para i de 1 at� 75 passo 1 fa�a
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