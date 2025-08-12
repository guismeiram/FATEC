package br.com.guismeiram.aula_01.Projeto_01;

public class CalculoSalario {
    private static double calcularDescontoSalarioCincoPorcento(double salario) {
        return salario * 0.05;
    }

    private static double calcularDescontoSalarioDezPorcento(double salario){
        return salario * 0.1;
    }

    private static double calcularDescontoSalarioQuinzePorcento(double salario){
        return salario * 0.15;
    }

    private static double calcularDescontoSalarioVintePorcento(double salario){
        return salario * 0.2;
    }

    public static double calcularDescontoSalarial(double salario) {
        double descontoSalarial = 0;
        if (salario < 1000) descontoSalarial = calcularDescontoSalarioCincoPorcento(salario);
        else if (salario < 2000) descontoSalarial = calcularDescontoSalarioDezPorcento(salario);
        else if (salario < 4000) descontoSalarial = calcularDescontoSalarioQuinzePorcento(salario);
        else descontoSalarial = calcularDescontoSalarioVintePorcento(salario);
        return salario - descontoSalarial;
    }

    //proximas mudanças mudar metodos para private
    //diminuir numeros de ifs
    //melhorar coesão de código
}
