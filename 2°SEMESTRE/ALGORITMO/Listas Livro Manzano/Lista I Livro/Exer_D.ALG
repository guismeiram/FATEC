Algoritmo "semnome"
// Disciplina   : [Linguagem e L�gica de Programa��o] 
// Professor   : Antonio Carlos Nicolodi 
// 
//  
// Efetuar o c�lculo da quantidade de litros de combust�vel gasta em uma viagem, utilizando um
//autom�vel que faz 12 quil�metros por litro. Para obter o c�lculo, o usu�rio deve fornecer o tempo
//gasto (vari�vel TEMPO) e a velocidade m�dia (vari�vel VELOCIDADE) durante a viagem. Desta
//forma, ser� poss�vel obter a dist�ncia percorrida com a f�rmula DIST�NCIA +-- TEMPO *
//VELOCIDADE. A partir do valor da dist�ncia, basta calcular a quantidade de litros de combust�vel
//utilizada na viagem com a f�rmula LITROS_USADOS +-- DIST�NCIA/ 12. O programa deve
//apresentar os valores da velocidade m�dia, tempo gasto na viagem, a dist�ncia percorrida e a
//quantidade de litros utilizada na viagem.
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 24/03/2024
Var
// Se��o de Declara��es das vari�veis 
     litros_usados, distancia, tp , vm : real
     //tempo gasto
     //velocidade media
Inicio
// Se��o de Comandos, procedimento, fun��es, operadores, etc... 
    escreva("Entre com a Distancia : ")
    leia(tp)
    
    escreva("Entre com o tempo : ")
    leia(vm)
    
    distancia <- tp * vm
    litros_usados <- distancia / 12
    
    escreva("Quantidade de litros usados � : ", litros_usados)

Fimalgoritmo