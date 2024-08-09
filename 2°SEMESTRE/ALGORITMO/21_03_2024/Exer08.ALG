Algoritmo "semnome"
// 
//  
// Descrição   : Aqui você descreve o que o programa faz! (função)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 21/03/2024
Var
// Seção de Declarações das variáveis 
   a, b: inteiro
   resp: caractere

Inicio
// Seção de Comandos, procedimento, funções, operadores, etc... 
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