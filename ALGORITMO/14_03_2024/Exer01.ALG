Algoritmo "semnome"
// 
//  
// Descri��o   : Aqui voc� descreve o que o programa faz! (fun��o)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 14/03/2024
Var
// Se��o de Declara��es das vari�veis 
      qt_pessoas: inteiro
      divisao: real

Inicio
// Se��o de Comandos, procedimento, fun��es, operadores, etc... 
        escreva("Digite o numero de pessoas:")
        leia(qt_pessoas)
        
        se(qt_pessoas > 0) ent�o
              divisao <- 20/ qt_pessoas
              escreva("Numero de peda�os: ", divisao)
        fimse

        se(qt_pessoas < 1) ent�o
              escreva("Impossivel dividir esse n�mero de pessoas")
        fimse
        
        
Fimalgoritmo