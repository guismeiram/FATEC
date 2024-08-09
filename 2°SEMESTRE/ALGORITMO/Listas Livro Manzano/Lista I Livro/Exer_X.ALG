Algoritmo "semnome"
// 
//  
// Descrição   : Aqui você descreve o que o programa faz! (função)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 25/03/2024
Var
// Seção de Declarações das variáveis 
base, indice, resultado: real

Inicio
   // Entrada de dados
   Escreva("Digite o valor da base: ")
   Leia(base)
   Escreva("Digite o valor do índice: ")
   Leia(indice)

   // Processamento
   resultado <- base ^ (1 / indice)

   // Saída de dados
   Escreva("A raiz de base ", base, " com índice ", indice, " é: ", resultado)
FimAlgoritmo