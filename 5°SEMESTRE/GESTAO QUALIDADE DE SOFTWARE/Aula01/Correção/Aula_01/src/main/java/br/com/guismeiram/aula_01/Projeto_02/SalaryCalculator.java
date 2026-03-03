package br.com.guismeiram.aula_01.Projeto_02;

public class SalaryCalculator {


    public static double calculateNetSalary(double grossSalary) {
        if (grossSalary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative."); // Validação
        }

        double taxRate = getTaxRate(grossSalary);  // Separa lógica da taxa em outro método
        double taxAmount = grossSalary * taxRate;
        return grossSalary - taxAmount;      // Retorna salário líquido
    }

    private static double getTaxRate(double salary) {  // Método dedicado à taxa
        if (salary < 1000) return 0.05;
        else if (salary < 2000) return 0.10;
        else if (salary < 4000) return 0.15;
        else return 0.20;
    }
}
