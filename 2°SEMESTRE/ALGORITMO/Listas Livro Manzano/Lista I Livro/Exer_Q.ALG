Algoritmo "semnome"
// Disciplina   : [Linguagem e L�gica de Programa��o] 
// Professor   : Antonio Carlos Nicolodi 
// 
//  
// Descri��o   : Aqui voc� descreve o que o programa faz! (fun��o)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 25/03/2024
Var
// Se??o de Declara??es das vari?veis
   cor: caractere
    raio, area: real

Inicio
// Se??o de Comandos, procedimento, fun??es, operadores, etc...
   PI <- 3,141592655359

   escreva("Digite a cor do circulo:")
   leia(cor)

   escreva("Digite o raio do circulo:")
   leia(raio)

   area <- PI* (raio * 2)

   escreva("Circulo de cor ", cor, " com raio de ", raio, " possui uma area de ", area)
Fimalgoritmo