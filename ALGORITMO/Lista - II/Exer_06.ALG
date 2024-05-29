Algoritmo "semnome"
// Disciplina   : [Linguagem e Lógica de Programação]
// Professor   : Antonio Carlos Nicolodi 
// Descrição   : Aqui você descreve o que o programa faz! (função)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 28/03/2024
Var
// Seção de Declarações das variáveis 
   x, y, z :inteiro

Inicio
// Seção de Comandos, procedimento, funções, operadores, etc... 

   escreva("Entre com o valor de x : ")
   leia(x)
   
   escreva("Entre com o valor de y : ")
   leia(y)
   
   escreva("Entre com o valor de z : ")
   leia(z)
   
   se( (  x = y ) e  ( y = z ) e ( x = z )) entao
        escreval("Triangulo equilatero ! ", x, " = " , y , " = ", z )
   senao
        se ( (x = y) e (x <> z) e (y = x)  ) entao
           escreval("Triangulo isoceles ! ", x, " = " , y , " != ", z )
        senao
           escreval("Triangulo escaleno ! ", x, " != " , y , " != ", z )
        fimse
   fimse
Fimalgoritmo