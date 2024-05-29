Algoritmo "semnome"
// 
//  
// Descrição   : Aqui você descreve o que o programa faz! (função)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 14/03/2024
Var
// Seção de Declarações das variáveis 
   op: inteiro
   num1, num2: real

Inicio
// Seção de Comandos, procedimento, funções, operadores, etc... 
   escreval("1- Soma")
   escreval("2- Subtração")
   escreval("3- Multiplicação")
   escreval("4-Divisão")
   
   escreval("Digite a opção desejada!")
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
        escreva("Subtração: ", (num1 - num2))
   caso 3
        escreva("Multiplicação: ", (num1*num2))
   caso 4
        escreva("Divisao: ", (num1\num2))
   outrocaso
        escreva("Opção Invalida")
   fimescolha

Fimalgoritmo