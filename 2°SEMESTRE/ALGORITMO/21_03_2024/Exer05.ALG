Algoritmo "semnome"
// 
//  
// Descri��o   : Aqui voc� descreve o que o programa faz! (fun��o)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 21/03/2024
Var
// Se��o de Declara��es das vari�veis 
   a, b, x: inteiro
   contpar, contimp: inteiro

Inicio
// Se��o de Comandos, procedimento, fun��es, operadores, etc... 
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