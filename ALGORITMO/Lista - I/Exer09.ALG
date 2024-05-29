Algoritmo "semnome"
// 
//  
// 09. Faça um algoritmo que leia a idade de uma pessoa expressa em ano, mês e dia e mostre-as em
//dias.
// 08. Faça um algoritmo que leia a idade de uma pessoa expressa em dias e mostre-a expressa em anos,
//meses e dias.
// Data atual  : 08/03/2024
Var
// Se??o de Declara??es das vari?veis
    idade, dias, meses : inteiro

Inicio
// Se??o de Comandos, procedimento, fun??es, operadores, etc...

   escreva("Entre com a sua idade:")
   leia(dias)
   idade <- (dias \ 364)
   meses <- (idade  * 12)

   escreval("Dias" , ":" ,dias)
   escreval("Meses" , ":" , meses)
   escreval("Idade" , ":" , idade)
Fimalgoritmo