Algoritmo "semnome"
// Disciplina   : [Linguagem e L�gica de Programa��o]
// Professor   : Antonio Carlos Nicolodi 
// Descri��o   : Aqui voc� descreve o que o programa faz! (fun��o)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 28/03/2024
Var
// Se��o de Declara��es das vari�veis 
   num1 , num2, recebe: inteiro

Inicio
// Se��o de Comandos, procedimento, fun��es, operadores, etc... 
    escreva("Entre com o primeiro valor : ")
    leia(num1)
    
    escreva("Entre com o segundo valor : ")
    leia(num2)
    


       
       se (num1 < num2 ) entao
           recebe <- num1
            num1 <- num2
            num2 <- recebe
         
             escreval("Ordem crescente : ", num2, num1)
         
             escreval("Ordem decrescente : ", num1, num2)
         
         
         senao
              recebe <- num1
              num1 <- num2
              num2 <- recebe
         
              escreval("Ordem crescente : ", num1, num2)
         
              escreval("Ordem decrescente : ", num2, num1)

    fimse


Fimalgoritmo