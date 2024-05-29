Algoritmo "semnome"
// Disciplina   : [Linguagem e Lógica de Programação]
// Professor   : Antonio Carlos Nicolodi 
// Descrição   : Aqui você descreve o que o programa faz! (função)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 04/04/2024
Var
   // Seção de Declarações das variáveis
   i , soma, cont, j, valor: inteiro

Inicio
   // Seção de Comandos, procedimento, funções, operadores, etc...
   enquanto (i <= 10)faça
      escreva("Entre com os valores : ")
      leia(valor)
      se(i <= 10) e i >= 20 entao
          cont <- cont + 1
          escreval("Numero dentro do ciclo de 10 a 20 : ", cont)
      senao
           j <- j + 1
           escreval("Numero dentro do ciclo : ",j)
      fimse
      
      i <- i + 1
      soma <- soma + i


   fimenquanto


Fimalgoritmo