Algoritmo "semnome"
// Disciplina   : [Linguagem e L�gica de Programa��o]
// Professor   : Antonio Carlos Nicolodi
// Descri��o   : Aqui voc� descreve o que o programa faz! (fun��o)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 11/04/2024
Var
   // Se��o de Declara��es das vari�veis
   vetorA : vetor[1..5] de inteiro
   i, cont, resto,  valor: inteiro
   divisor: real

Inicio
   // Se��o de Comandos, procedimento, fun��es, operadores, etc...
   i <- 1

   para i de 1 ate 5 passo 1 fa�a
        leia(vetorA[i])
   fimpara


  // para i de 1 ate vetorA[i] passo 1 fa�a


      //se (  ( resto mod 2 = 0 ) e ( resto mod 2 = 1 )  ) entao
      
      enquanto vetorA[i] > i fa�a
           se(i = cont) entao
               vetorA[i] <- vetorA[i] mod 2
               escreval(vetorA[i])
           fimse
         cont <- cont + 1

         //valor <- vetorA[i]
         //valor <- valor / 2
         escreval(resto)
         escreval(divisor)
         escreval(vetorA[i])
         escreval("numero de voltas : ", cont)
      fimenquanto
     // fimse
   //fimpara



Fimalgoritmo