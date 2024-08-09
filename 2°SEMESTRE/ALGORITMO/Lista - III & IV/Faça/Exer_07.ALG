Algoritmo "semnome"
// Disciplina   : [Linguagem e Lógica de Programação]
// Professor   : Antonio Carlos Nicolodi 
// Descrição   : Aqui você descreve o que o programa faz! (função)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 30/03/2024
Var
// Seção de Declarações das variáveis 
   i, valor , cont: inteiro

Inicio
// Seção de Comandos, procedimento, funções, operadores, etc... 
   para i de 1 até 80 passo 1 faça
          leia(valor)
          se((valor >= 10) e (valor <= 150)) entao
               cont <- cont + 1
          fimse
   fimpara

   escreval("Valores entre 10 e 150 : ", cont)
Fimalgoritmo