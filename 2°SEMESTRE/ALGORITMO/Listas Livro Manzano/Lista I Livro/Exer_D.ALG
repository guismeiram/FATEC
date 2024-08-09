Algoritmo "semnome"
// Disciplina   : [Linguagem e Lógica de Programação] 
// Professor   : Antonio Carlos Nicolodi 
// 
//  
// Efetuar o cálculo da quantidade de litros de combustível gasta em uma viagem, utilizando um
//automóvel que faz 12 quilômetros por litro. Para obter o cálculo, o usuário deve fornecer o tempo
//gasto (variável TEMPO) e a velocidade média (variável VELOCIDADE) durante a viagem. Desta
//forma, será possível obter a distância percorrida com a fórmula DISTÂNCIA +-- TEMPO *
//VELOCIDADE. A partir do valor da distância, basta calcular a quantidade de litros de combustível
//utilizada na viagem com a fórmula LITROS_USADOS +-- DISTÂNCIA/ 12. O programa deve
//apresentar os valores da velocidade média, tempo gasto na viagem, a distância percorrida e a
//quantidade de litros utilizada na viagem.
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 24/03/2024
Var
// Seção de Declarações das variáveis 
     litros_usados, distancia, tp , vm : real
     //tempo gasto
     //velocidade media
Inicio
// Seção de Comandos, procedimento, funções, operadores, etc... 
    escreva("Entre com a Distancia : ")
    leia(tp)
    
    escreva("Entre com o tempo : ")
    leia(vm)
    
    distancia <- tp * vm
    litros_usados <- distancia / 12
    
    escreva("Quantidade de litros usados é : ", litros_usados)

Fimalgoritmo