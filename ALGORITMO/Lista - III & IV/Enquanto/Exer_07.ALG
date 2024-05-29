Algoritmo "semnome"
// Disciplina   : [Linguagem e Lógica de Programação]
// Professor   : Antonio Carlos Nicolodi 
// Descrição   : Aqui você descreve o que o programa faz! (função)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 04/04/2024
Var
// Seção de Declarações das variáveis
   valor, i :inteiro

Inicio
// Seção de Comandos, procedimento, funções, operadores, etc...
   leia(valor)
   i <- 1
   enquanto (i < valor) faça
            se(i < valor) entao
                 i <- i + 1
                 valor <- valor * i
            fimse
   fimenquanto

   escreval("O Fatorial é : ", valor, i)
Fimalgoritmo