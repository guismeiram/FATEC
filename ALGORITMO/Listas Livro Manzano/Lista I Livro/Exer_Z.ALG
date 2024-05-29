Algoritmo "semnome"
// 
//  
// Descrição   : Aqui você descreve o que o programa faz! (função)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 25/03/2024
Var
// Seção de Declarações das variáveis 
   A, B: inteiro
   resultado: real

Inicio
// Seção de Comandos, procedimento, funções, operadores, etc... 
    // Entrada de dados
   Escreva("Digite o valor de A: ")
   Leia(A)
   Escreva("Digite o valor de B: ")
   Leia(B)

   // Processamento
   Se B <> 0 Então
      resultado <- (A / B) ^ 2
      Escreva("O resultado do quadrado da divisão de ", A, " por ", B, " é: ", resultado)
   Senão
      Escreva("Não é possível dividir por zero.")
   FimSe

Fimalgoritmo