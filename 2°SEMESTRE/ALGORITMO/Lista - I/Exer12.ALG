Algoritmo "semnome"
// 
//  
// Descri��o   : Aqui voc� descreve o que o programa faz! (fun��o)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 08/03/2024
Var
// Se��o de Declara��es das vari�veis 
    prestacao1, valor1, tempo1, taxa1: real

Inicio
// Se��o de Comandos, procedimento, fun��es, operadores, etc... 
     escreva("Entre com o tempo : ")
     leia(tempo1)
     
     escreva("Entre com o valor : ")
     leia(valor1)
     
     escreva("Entre com o taxa : ")
     leia(taxa1)
     
     prestacao1 <- valor1 + (valor1 * (taxa1 / 100) * tempo1)
     
     escreval("O valor da preta��o � ", " : ", prestacao1)

Fimalgoritmo