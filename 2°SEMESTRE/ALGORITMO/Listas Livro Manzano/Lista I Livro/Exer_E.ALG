Algoritmo "semnome"
// Disciplina   : [Linguagem e Lógica de Programação] 
// Professor   : Antonio Carlos Nicolodi 
// 
//  
// Descrição   : Aqui você descreve o que o programa faz! (função)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 24/03/2024
Var
// Seção de Declarações das variáveis 
   prest, v, ta, t : real

Inicio
// Seção de Comandos, procedimento, funções, operadores, etc... 
    escreva("Entre com valor a ser calculado : ")
    leia(v)
    
    escreva("Entre com a taxa : ")
    leia(ta)
    
    escreva("Entre com o tempo : ")
    leia(t)
    
    prest <- v + (v * (ta/100) * t)

    escreva("O valor da prestação é : ", prest)

Fimalgoritmo