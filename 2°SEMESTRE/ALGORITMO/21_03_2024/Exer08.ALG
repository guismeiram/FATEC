Algoritmo "semnome"
// 
//  
// Descri��o   : Aqui voc� descreve o que o programa faz! (fun��o)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 21/03/2024
Var
// Se��o de Declara��es das vari�veis 
   a, b: inteiro
   resp: caractere

Inicio
// Se��o de Comandos, procedimento, fun��es, operadores, etc... 
    resp <- "s"
    
    enquanto (resp = "s") ou (resp = "S") faca
        escreva("Digite um numero: ")
        leia(a)
        leia(b)
        escreval("Soma = ", (a + b))
        
        escreva("Deseja continuar (S/N): ")
        leia(resp)
    fimenquanto

Fimalgoritmo