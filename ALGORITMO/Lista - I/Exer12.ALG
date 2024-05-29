Algoritmo "semnome"
// 
//  
// Descrição   : Aqui você descreve o que o programa faz! (função)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 08/03/2024
Var
// Seção de Declarações das variáveis 
    prestacao1, valor1, tempo1, taxa1: real

Inicio
// Seção de Comandos, procedimento, funções, operadores, etc... 
     escreva("Entre com o tempo : ")
     leia(tempo1)
     
     escreva("Entre com o valor : ")
     leia(valor1)
     
     escreva("Entre com o taxa : ")
     leia(taxa1)
     
     prestacao1 <- valor1 + (valor1 * (taxa1 / 100) * tempo1)
     
     escreval("O valor da pretação é ", " : ", prestacao1)

Fimalgoritmo