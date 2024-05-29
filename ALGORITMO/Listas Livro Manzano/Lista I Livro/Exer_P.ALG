Algoritmo "semnome"
// Disciplina   : [Linguagem e Lógica de Programação] 
// Professor   : Antonio Carlos Nicolodi 
// 
//  
// Descrição   : Aqui você descreve o que o programa faz! (função)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 25/03/2024
Var
// Seção de Declarações das variáveis 
   sm, ns, pr, percentual: real
   //sm = salario mensal
   //pr = reajuste
   //ns = valor do novo salario
Inicio
// Seção de Comandos, procedimento, funções, operadores, etc... 
    escreva("Entre com o seu salario : ")
    leia(sm)
    
    escreva("Entre com o valor do reajuste : ")
    leia(pr)
    
    percentual <- (sm * pr) / 100
    ns <- ( sm +  percentual)

    escreva("O valor do seu novo salario é : ", ns)
Fimalgoritmo