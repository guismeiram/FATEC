Algoritmo "semnome"
// Disciplina   : [Linguagem e L�gica de Programa��o]
// Professor   : Antonio Carlos Nicolodi 
// Descri��o   : Aqui voc� descreve o que o programa faz! (fun��o)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 04/04/2024
Var
   // Se��o de Declara��es das vari�veis
   i , soma, cont, j, valor: inteiro

Inicio
   // Se��o de Comandos, procedimento, fun��es, operadores, etc...
   enquanto (i <= 10)fa�a
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