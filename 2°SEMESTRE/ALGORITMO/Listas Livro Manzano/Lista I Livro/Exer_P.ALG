Algoritmo "semnome"
// Disciplina   : [Linguagem e L�gica de Programa��o] 
// Professor   : Antonio Carlos Nicolodi 
// 
//  
// Descri��o   : Aqui voc� descreve o que o programa faz! (fun��o)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 25/03/2024
Var
// Se��o de Declara��es das vari�veis 
   sm, ns, pr, percentual: real
   //sm = salario mensal
   //pr = reajuste
   //ns = valor do novo salario
Inicio
// Se��o de Comandos, procedimento, fun��es, operadores, etc... 
    escreva("Entre com o seu salario : ")
    leia(sm)
    
    escreva("Entre com o valor do reajuste : ")
    leia(pr)
    
    percentual <- (sm * pr) / 100
    ns <- ( sm +  percentual)

    escreva("O valor do seu novo salario � : ", ns)
Fimalgoritmo