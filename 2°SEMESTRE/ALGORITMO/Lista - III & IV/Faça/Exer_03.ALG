Algoritmo "semnome"
// Disciplina   : [Linguagem e Lógica de Programação]
// Professor   : Antonio Carlos Nicolodi 
// Descrição   : Aqui você descreve o que o programa faz! (função)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 29/03/2024
Var
// Seção de Declarações das variáveis 
    i, valor, soma, cont, somaNegativos, j: inteiro

Inicio
// Seção de Comandos, procedimento, funções, operadores, etc... 
    //para i de 1 até 20 passo 1 faça
            //soma <- soma + valor



    //fimpara
    
    para i de 1 até 20 passo 1 faça
         leia(valor)
         se (valor > 0) entao
            soma <- soma + valor
            j <- j + 1
         senao
            cont <- cont + 1
            somaNegativos <- somaNegativos + valor

         fimse
    fimpara
    
    escreval("Quantidade de numeros positivos : " , j)
    escreval("Soma de numeros de positivos : " , soma)
    escreval(" Soma de numeros negativos : " , somaNegativos)
    escreval("Quantidade de numeros negativos : " , cont)
    
Fimalgoritmo