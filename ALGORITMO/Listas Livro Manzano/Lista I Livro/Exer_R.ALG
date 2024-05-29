Algoritmo "semnome"
// Disciplina   : [Linguagem e Lógica de Programação] 
// Professor   : Antonio Carlos Nicolodi 
// 
//  
// Descrição   : Aqui você descreve o que o programa faz! (função)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 25/03/2024
Var
// Seção de Declarações das variáveis 
     votosValidosA, votosValidosB, votosValidosC, votosNulos, votosBranco, totalEleitores :inteiro
     percentualValidos, percentualA, percentualB, percentualC, percentualNulos, percentualBranco : real

Inicio
 // Entrada de dados
    Escreva("Informe a quantidade de votos válidos para o candidato A: ")
    Leia(votosValidosA)
    Escreva("Informe a quantidade de votos válidos para o candidato B: ")
    Leia(votosValidosB)
    Escreva("Informe a quantidade de votos válidos para o candidato C: ")
    Leia(votosValidosC)
    Escreva("Informe a quantidade de votos nulos: ")
    Leia(votosNulos)
    Escreva("Informe a quantidade de votos em branco: ")
    Leia(votosBranco)

    // Processamento
    totalEleitores <- votosValidosA + votosValidosB + votosValidosC + votosNulos + votosBranco
    percentualValidos <- (votosValidosA + votosValidosB + votosValidosC) / totalEleitores * 100
    percentualA <- votosValidosA / totalEleitores * 100
    percentualB <- votosValidosB / totalEleitores * 100
    percentualC <- votosValidosC / totalEleitores * 100
    percentualNulos <- votosNulos / totalEleitores * 100
    percentualBranco <- votosBranco / totalEleitores * 100

    // Saída de dados
    Escreva("Número total de eleitores: ", totalEleitores)
    Escreva("Percentual de votos válidos em relação à quantidade de eleitores: ", percentualValidos, "%")
    Escreva("Percentual de votos válidos do candidato A: ", percentualA, "%")
    Escreva("Percentual de votos válidos do candidato B: ", percentualB, "%")
    Escreva("Percentual de votos válidos do candidato C: ", percentualC, "%")
    Escreva("Percentual de votos nulos: ", percentualNulos, "%")
    Escreva("Percentual de votos em branco: ", percentualBranco, "%")


Fimalgoritmo