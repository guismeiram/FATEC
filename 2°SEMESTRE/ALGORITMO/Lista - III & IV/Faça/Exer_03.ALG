Algoritmo "semnome"
// Disciplina   : [Linguagem e L�gica de Programa��o]
// Professor   : Antonio Carlos Nicolodi 
// Descri��o   : Aqui voc� descreve o que o programa faz! (fun��o)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 29/03/2024
Var
// Se��o de Declara��es das vari�veis 
    i, valor, soma, cont, somaNegativos, j: inteiro

Inicio
// Se��o de Comandos, procedimento, fun��es, operadores, etc... 
    //para i de 1 at� 20 passo 1 fa�a
            //soma <- soma + valor



    //fimpara
    
    para i de 1 at� 20 passo 1 fa�a
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