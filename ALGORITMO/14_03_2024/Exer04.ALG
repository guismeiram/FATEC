Algoritmo "semnome"
// 
//  
// Descrição   : Aqui você descreve o que o programa faz! (função)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 14/03/2024
Var
// Se??o de Declara??es das vari?veis
   op: caracter
   num1, num2: real

Inicio
// Se??o de Comandos, procedimento, fun??es, operadores, etc...
   escreval("S- Soma")
   escreval("B- Subtração")
   escreval("M- Multiplicão")
   escreval("D- Divisão")

   escreval("Digite a opção desejada!")
   leia(op)

   escreval("Digite o primeiro numero: ")
   leia(num1)

   escreval("Digite o segundo numero: ")
   leia(num2)


   escolha(op)
   caso "S"
        escreva("Soma: ", (num1 + num2))
   caso "B"
        escreva("Subtração: ", (num1 - num2))
   caso "M"
        escreva("Multiplicação: ", (num1*num2))
   caso "D"
        escreva("Divisão: ", (num1\num2))
   outrocaso
        escreva("Opção Invalida")
   fimescolha

Fimalgoritmo