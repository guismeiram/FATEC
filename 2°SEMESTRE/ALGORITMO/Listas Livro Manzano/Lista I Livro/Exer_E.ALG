Algoritmo "semnome"
// Disciplina   : [Linguagem e L�gica de Programa��o] 
// Professor   : Antonio Carlos Nicolodi 
// 
//  
// Descri��o   : Aqui voc� descreve o que o programa faz! (fun��o)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 24/03/2024
Var
// Se��o de Declara��es das vari�veis 
   prest, v, ta, t : real

Inicio
// Se��o de Comandos, procedimento, fun��es, operadores, etc... 
    escreva("Entre com valor a ser calculado : ")
    leia(v)
    
    escreva("Entre com a taxa : ")
    leia(ta)
    
    escreva("Entre com o tempo : ")
    leia(t)
    
    prest <- v + (v * (ta/100) * t)

    escreva("O valor da presta��o � : ", prest)

Fimalgoritmo