# Fluxo de trabalho com Git para nova funcionalidade
git checkout develop         # Muda para o branch develop
git pull origin develop     # Atualiza com as últimas alterações remotas
git checkout -b feature/login  # Cria e muda para um novo branch feature/login

__________________________________________________________

# Comandos para versionamento das alterações
git add .                  # Adiciona todas as mudanças para staging
git commit -m "Implementa validação de senha"  # Cria commit com mensagem descritiva
__________________________________________________________

# Publicação e integração contínua
git push origin feature/login  # Envia o branch para o repositório remoto
# Criar PR no GitHub para merge em develop  # Processo de code review
__________________________________________________________


# GitHub Action para validação automática de PRs
name: PR Validation

on: [pull_request]  # Dispara em eventos de pull request

jobs:
  build:
    runs-on: ubuntu-latest   # Executa em container Ubuntu
    steps:
      - uses: actions/checkout@v3  # Checkout do código
      - name: Set up JDK 17
        uses: actions/setup-java@v3
        with:
          java-version: '17'  # Configura JDK 17
      - name: Build and Test
        run: mvn clean test   # Executa build e testes
		
__________________________________________________________

// Exemplo de código problemático para revisão
public class Calculadora {
    public int divide(int a, int b) {
        return a / b; // Problema grave: falta tratamento de divisão por zero!
    }
}

__________________________________________________________

// Versão refatorada com tratamento adequado
public int divide(int a, int b) {
    if (b == 0) {
        throw new ArithmeticException("Divisor não pode ser zero");  # Fail fast
    }
    return a / b;
}

__________________________________________________________

