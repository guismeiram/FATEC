Algoritmo "semnome"
// 
//  
// Descrição   : Aqui você descreve o que o programa faz! (função)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 21/03/2024
Var
// Seção de Declarações das variáveis 
   a, b, x: inteiro
   contpar, contimp: inteiro

Inicio
// Seção de Comandos, procedimento, funções, operadores, etc... 
   escreva("Digite um numero: ")
   leia(a)
   
   escreva("Digite um numero: ")
   leia(b)
   
   se (a < b) entao
      para x <- a ate b passo 1 faca
           se( x mod 2 = 0 ) entao
                contpar <- contpar + 1
           senao
                contimp <- contimp + 1
           fimse
       fimpara
   senao
        para x <- b ate a passo 1 faca
             se (x mod 2 = 0) entao
                contpar <- contpar + 1
             senao
                  contimp <- contimp + 1
             fimse
        fimpara
   fimse
   
   escreval( contimp , " Impares: ")
   escreval( contpar, " pares: ")

Fimalgoritmo