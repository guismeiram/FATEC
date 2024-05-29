Algoritmo "semnome"
// Disciplina   : [Linguagem e Lógica de Programação]
// Professor   : Antonio Carlos Nicolodi 
// Descrição   : Aqui você descreve o que o programa faz! (função)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 28/03/2024
Var
// Seção de Declarações das variáveis 
   nota1, nota2, media: real

Inicio
// Seção de Comandos, procedimento, funções, operadores, etc... 
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