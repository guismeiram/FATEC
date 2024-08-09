Algoritmo "semnome"
// 
//  
// Descrição   : Aqui você descreve o que o programa faz! (função)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 14/03/2024
Var
// Seção de Declarações das variáveis 
      qt_pessoas: inteiro
      divisao: real

Inicio
// Seção de Comandos, procedimento, funções, operadores, etc... 
        escreva("Digite o numero de pessoas:")
        leia(qt_pessoas)
        
        se(qt_pessoas > 0) então
              divisao <- 20/ qt_pessoas
              escreva("Numero de pedaços: ", divisao)
        fimse

        se(qt_pessoas < 1) então
              escreva("Impossivel dividir esse número de pessoas")
        fimse
        
        
Fimalgoritmo