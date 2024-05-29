Algoritmo "semnome"
// 
//  
// Descrição   : Aqui você descreve o que o programa faz! (função)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 21/03/2024
Var
// Seção de Declarações das variáveis 

     n, soma: real
Inicio
// Seção de Comandos, procedimento, funções, operadores, etc... 
     soma <- 0
     n <- 0
     
     repita
        soma <- soma + n
             escreva("Digite um numero:")
             leia(n)
     ate n < 0
     escreva("Soma total = ", soma)

Fimalgoritmo