Algoritmo "semnome"
// 
//  
// Descri��o   : Aqui voc� descreve o que o programa faz! (fun��o)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 25/03/2024
Var
// Se��o de Declara��es das vari�veis 
   A, B: inteiro
   resultado: real

Inicio
// Se��o de Comandos, procedimento, fun��es, operadores, etc... 
    // Entrada de dados
   Escreva("Digite o valor de A: ")
   Leia(A)
   Escreva("Digite o valor de B: ")
   Leia(B)

   // Processamento
   Se B <> 0 Ent�o
      resultado <- (A / B) ^ 2
      Escreva("O resultado do quadrado da divis�o de ", A, " por ", B, " �: ", resultado)
   Sen�o
      Escreva("N�o � poss�vel dividir por zero.")
   FimSe

Fimalgoritmo