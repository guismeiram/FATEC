Algoritmo "semnome"
// 
//  
// Descri��o   : Aqui voc� descreve o que o programa faz! (fun��o)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 14/03/2024
Var
// Se��o de Declara��es das vari�veis 
   op: inteiro
   num1, num2: real

Inicio
// Se��o de Comandos, procedimento, fun��es, operadores, etc... 
   escreval("1- Soma")
   escreval("2- Subtra��o")
   escreval("3- Multiplica��o")
   escreval("4-Divis�o")
   
   escreval("Digite a op��o desejada!")
   leia(op)
   se(op >= 1) e (op<=4) entao
          escreval("Digite o primeiro numero: ")
          leia(num1)
   
          escreval("Digite o segundo numero: ")
          leia(num2)
   fimse
   
   escolha(op)
   caso 1
        escreva("Soma: ", (num1 + num2))
   caso 2
        escreva("Subtra��o: ", (num1 - num2))
   caso 3
        escreva("Multiplica��o: ", (num1*num2))
   caso 4
        escreva("Divisao: ", (num1\num2))
   outrocaso
        escreva("Op��o Invalida")
   fimescolha

Fimalgoritmo