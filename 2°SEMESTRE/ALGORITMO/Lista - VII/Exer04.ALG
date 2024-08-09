Algoritmo "semnome"
// Disciplina   : [Linguagem e Lógica de Programação]
// Professor   : Antonio Carlos Nicolodi 
// Descrição   : Aqui você descreve o que o programa faz! (função)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 19/06/2024
Var
    valor, soma : inteiro

// Função para solicitar e consistir um valor inteiro positivo
Funcao SolicitarValorPositivo() : inteiro
Var
    numero : inteiro
Inicio
    Repita
        Escreva("Digite um valor inteiro positivo: ")
        Leia(numero)
        Se numero <= 0 Entao
            EscrevaL("O valor deve ser um inteiro positivo.")
        FimSe
    Ate numero > 0
    Retorne numero
FimFuncao

// Função para calcular a somatória dos números até o valor informado
Funcao CalcularSomatoria(n : inteiro) : inteiro
Var
    i, soma : inteiro
Inicio
    soma <- 0
    Para i de 1 ate n faca
        soma <- soma + i
    FimPara
    Retorne soma
FimFuncao

Inicio
    // Solicita o valor inteiro positivo
    valor <- SolicitarValorPositivo()

    // Calcula a somatória dos números até o valor informado
    soma <- CalcularSomatoria(valor)

    // Mostra a somatória
    EscrevaL("A somatória dos números até ", valor, " é: ", soma)
FimAlgoritmo