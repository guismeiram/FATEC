Algoritmo "semnome"
// 
//  
// Descri��o   : Aqui voc� descreve o que o programa faz! (fun��o)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 14/03/2024
Var
// Se??o de Declara??es das vari?veis
   op: caracter
   num1, num2: real

Inicio
// Se??o de Comandos, procedimento, fun??es, operadores, etc...
   escreval("S- Soma")
   escreval("B- Subtra��o")
   escreval("M- Multiplic�o")
   escreval("D- Divis�o")

   escreval("Digite a op��o desejada!")
   leia(op)

   escreval("Digite o primeiro numero: ")
   leia(num1)

   escreval("Digite o segundo numero: ")
   leia(num2)


   escolha(op)
   caso "S"
        escreva("Soma: ", (num1 + num2))
   caso "B"
        escreva("Subtra��o: ", (num1 - num2))
   caso "M"
        escreva("Multiplica��o: ", (num1*num2))
   caso "D"
        escreva("Divis�o: ", (num1\num2))
   outrocaso
        escreva("Op��o Invalida")
   fimescolha

Fimalgoritmo