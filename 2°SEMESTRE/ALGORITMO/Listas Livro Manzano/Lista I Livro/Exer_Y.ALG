Algoritmo "semnome"
// 
//  
// Descri��o   : Aqui voc� descreve o que o programa faz! (fun��o)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 25/03/2024
Var
// Se��o de Declara��es das vari�veis 
   numero, antecessor, sucessor: inteiro

Inicio
// Se��o de Comandos, procedimento, fun��es, operadores, etc... 
    // Entrada de dados
   Escreva("Digite um n�mero inteiro: ")
   Leia(numero)

   // Processamento
   antecessor <- numero - 1
   sucessor <- numero + 1

   // Sa�da de dados
   Escreva("O antecessor de ", numero, " �: ", antecessor)
   Escreva("O sucessor de ", numero, " �: ", sucessor)

Fimalgoritmo