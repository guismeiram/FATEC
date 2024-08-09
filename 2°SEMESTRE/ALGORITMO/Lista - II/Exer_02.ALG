Algoritmo "semnome"
// Disciplina   : [Linguagem e Lógica de Programação]
// Professor   : Antonio Carlos Nicolodi 
// Descrição   : Aqui você descreve o que o programa faz! (função)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 28/03/2024
Var
// Seção de Declarações das variáveis 
   delta, a, b, c, x1, x2 : real

Inicio
// Seção de Comandos, procedimento, funções, operadores, etc... 
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
             escreval("Não existe valores reais:")
        fimse
   fimse
        

Fimalgoritmo