Algoritmo "semnome"
// 
//  
// Descri��o   : Aqui voc� descreve o que o programa faz! (fun��o)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 21/03/2024
Var
// Se��o de Declara��es das vari�veis 
   x, n: inteiro

Inicio
// Se��o de Comandos, procedimento, fun��es, operadores, etc... 
   escreva("Digite um numero: ")
   leia(n)
   
   se ( n > 0) entao
      para x <- n ate 0 passo -1 fa�a
           escreval(x)
      fimpara
   senao
        para x <- n ate 0 passo 1 fa�a
             escreval(x)
        fimpara
   fimse

Fimalgoritmo