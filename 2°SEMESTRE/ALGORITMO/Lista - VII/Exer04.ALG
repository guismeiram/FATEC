Algoritmo "semnome"
// Disciplina   : [Linguagem e L�gica de Programa��o]
// Professor   : Antonio Carlos Nicolodi 
// Descri��o   : Aqui voc� descreve o que o programa faz! (fun��o)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 19/06/2024
Var
    valor, soma : inteiro

// Fun��o para solicitar e consistir um valor inteiro positivo
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

// Fun��o para calcular a somat�ria dos n�meros at� o valor informado
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

    // Calcula a somat�ria dos n�meros at� o valor informado
    soma <- CalcularSomatoria(valor)

    // Mostra a somat�ria
    EscrevaL("A somat�ria dos n�meros at� ", valor, " �: ", soma)
FimAlgoritmo