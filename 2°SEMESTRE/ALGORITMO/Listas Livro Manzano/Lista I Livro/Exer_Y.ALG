Algoritmo "semnome"
// 
//  
// Descrição   : Aqui você descreve o que o programa faz! (função)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 25/03/2024
Var
// Seção de Declarações das variáveis 
   numero, antecessor, sucessor: inteiro

Inicio
// Seção de Comandos, procedimento, funções, operadores, etc... 
    // Entrada de dados
   Escreva("Digite um número inteiro: ")
   Leia(numero)

   // Processamento
   antecessor <- numero - 1
   sucessor <- numero + 1

   // Saída de dados
   Escreva("O antecessor de ", numero, " é: ", antecessor)
   Escreva("O sucessor de ", numero, " é: ", sucessor)

Fimalgoritmo