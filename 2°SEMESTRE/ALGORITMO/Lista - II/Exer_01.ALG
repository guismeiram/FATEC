Algoritmo "semnome"
// Disciplina   : [Linguagem e L�gica de Programa��o]
// Professor   : Antonio Carlos Nicolodi 
// Descri��o   : Aqui voc� descreve o que o programa faz! (fun��o)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 28/03/2024
Var
// Se��o de Declara��es das vari�veis 
   nota1, nota2, media: real

Inicio
// Se��o de Comandos, procedimento, fun��es, operadores, etc... 
    escreva("Entre com a sua primeira nota : ")
    leia(nota1)
    
    escreva("Entre com a sua segunda nota : ")
    leia(nota2)
    
    media <- (nota1 + nota2) / 2
    
    se(media >= 6) entao
        escreval(" Aprovado !!!")
    senao
         escreval(" Reprovado, tente outra vez.")
    fimse

Fimalgoritmo