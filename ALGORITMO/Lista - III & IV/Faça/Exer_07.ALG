Algoritmo "semnome"
// Disciplina   : [Linguagem e L�gica de Programa��o]
// Professor   : Antonio Carlos Nicolodi 
// Descri��o   : Aqui voc� descreve o que o programa faz! (fun��o)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 30/03/2024
Var
// Se��o de Declara��es das vari�veis 
   i, valor , cont: inteiro

Inicio
// Se��o de Comandos, procedimento, fun��es, operadores, etc... 
   para i de 1 at� 80 passo 1 fa�a
          leia(valor)
          se((valor >= 10) e (valor <= 150)) entao
               cont <- cont + 1
          fimse
   fimpara

   escreval("Valores entre 10 e 150 : ", cont)
Fimalgoritmo