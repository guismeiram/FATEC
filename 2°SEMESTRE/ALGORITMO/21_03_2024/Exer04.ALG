Algoritmo "semnome"
// 
//  
// Descrição   : Aqui você descreve o que o programa faz! (função)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 21/03/2024
Var
// Seção de Declarações das variáveis 
   x, n: inteiro

Inicio
// Seção de Comandos, procedimento, funções, operadores, etc... 
   escreva("Digite um numero: ")
   leia(n)
   
   se ( n > 0) entao
      para x <- n ate 0 passo -1 faça
           escreval(x)
      fimpara
   senao
        para x <- n ate 0 passo 1 faça
             escreval(x)
        fimpara
   fimse

Fimalgoritmo