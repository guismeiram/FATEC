Algoritmo "semnome"
// 
//  
// 04. Calcular e apresentar o valor do volume de uma lata de óleo, utilizando a fórmula:
//VOLUME <-- 3.14159 * RAIO2  * ALTURA.


Var
// variaveis
   raio, altura, volume: real

Inicio
// Se??o de Comandos, procedimento, fun??es, operadores, etc...
     PI = 3.14159
     
     escreva("Informe o raio:")
     leia(raio)
     escreva("Informe a altura:")
     leia(altura)

     volume <- PI * (raio ^ 2) * altura
     escreval("o volume é", " : ", volume )
     escreval("raio"," : ", raio )
     escreval("altura 2", " : ", altura)
Fimalgoritmo