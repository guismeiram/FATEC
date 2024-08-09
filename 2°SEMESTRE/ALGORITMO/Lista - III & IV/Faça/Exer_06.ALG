Algoritmo "semnome"
// Disciplina   : [Linguagem e Lógica de Programação]
// Professor   : Antonio Carlos Nicolodi 
// Descrição   : Aqui você descreve o que o programa faz! (função)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 30/03/2024
Var
// Seção de Declarações das variáveis 
   soma, media, nota: real
   i: inteiro

Inicio
// Seção de Comandos, procedimento, funções, operadores, etc... 
       para i de 1 ate 40 passo 1 faça
            leia(nota)
            soma <- soma + nota
            media <- soma / i
       fimpara

       escreval("A soma é :" ,  soma)
       escreval("A media é : ", media)

Fimalgoritmo