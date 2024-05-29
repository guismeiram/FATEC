Algoritmo "semnome"
// Disciplina   : [Linguagem e Lógica de Programação]
// Professor   : Antonio Carlos Nicolodi
// Descrição   : Aqui você descreve o que o programa faz! (função)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 11/04/2024
Var
   // Seção de Declarações das variáveis
   vetorA : vetor[1..5] de inteiro
   i, cont, resto,  valor: inteiro
   divisor: real

Inicio
   // Seção de Comandos, procedimento, funções, operadores, etc...
   i <- 1

   para i de 1 ate 5 passo 1 faça
        leia(vetorA[i])
   fimpara


  // para i de 1 ate vetorA[i] passo 1 faça


      //se (  ( resto mod 2 = 0 ) e ( resto mod 2 = 1 )  ) entao
      
      enquanto vetorA[i] > i faça
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