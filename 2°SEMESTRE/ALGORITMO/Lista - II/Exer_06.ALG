Algoritmo "semnome"
// Disciplina   : [Linguagem e L�gica de Programa��o]
// Professor   : Antonio Carlos Nicolodi 
// Descri��o   : Aqui voc� descreve o que o programa faz! (fun��o)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 28/03/2024
Var
// Se��o de Declara��es das vari�veis 
   x, y, z :inteiro

Inicio
// Se��o de Comandos, procedimento, fun��es, operadores, etc... 

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