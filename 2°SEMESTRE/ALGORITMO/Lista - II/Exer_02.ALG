Algoritmo "semnome"
// Disciplina   : [Linguagem e L�gica de Programa��o]
// Professor   : Antonio Carlos Nicolodi 
// Descri��o   : Aqui voc� descreve o que o programa faz! (fun��o)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 28/03/2024
Var
// Se��o de Declara��es das vari�veis 
   delta, a, b, c, x1, x2 : real

Inicio
// Se��o de Comandos, procedimento, fun��es, operadores, etc... 
   escreva("Entre com o valor de A : ")
   leia(a)
   
   escreva("Entre com o valor de B : ")
   leia(b)
   
   escreva("Entre com o valor de C : ")
   leia(c)

   delta <- (b * b) - 4 * a * c
   
   se (delta > 0) entao
       x1 <- (-b) + raizq(delta) / 2 * a
       escreval(x1)
       
       x2 <- (-b) - raizq(delta) / 2 * a
       escreval(x2)
   senao
        se ( delta = 0 )  entao
           x1 <- (-b) + raizq(delta) / 2 * a
           escreva(x1)
        senao
             escreval("N�o existe valores reais:")
        fimse
   fimse
        

Fimalgoritmo