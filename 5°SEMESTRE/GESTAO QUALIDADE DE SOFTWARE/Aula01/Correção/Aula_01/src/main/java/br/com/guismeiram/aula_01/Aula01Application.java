package br.com.guismeiram.aula_01;

import br.com.guismeiram.aula_01.Projeto_03.OrderProcessor;
import br.com.guismeiram.aula_01.Projeto_04.OrderProcessor2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import static br.com.guismeiram.aula_01.Projeto_01.CalculoSalario.calcularDescontoSalarial;
import static br.com.guismeiram.aula_01.Projeto_02.SalaryCalculator.calculateNetSalary;


@SpringBootApplication
public class Aula01Application {

    public static void main(String[] args) {
        //Exercicio 01
        double salario = 5000;
        double salarioLiquido = calcularDescontoSalarial(salario);
        System.out.println("Exercicio 01 : " +  "Salario Liquido: " + salarioLiquido);

        //Exercicio 02
        double grossSalary = 5000.0;          // Nome claro ("grossSalary" = salário bruto)
        double netSalary = calculateNetSalary(grossSalary);  // Nome autoexplicativo
        System.out.println("Exercicio 02 : " + "Net Salary: " + netSalary);

        //Exercicio 03
        double[] prices = {100.0,2000.0,3000.0};
        int qty[] = {1,2,3};
        OrderProcessor o = new OrderProcessor();
        System.out.println("Resultado Exercicio 3 : " + o.calcTotal(prices, qty));

        //Exercicio04
        double[] prices2 = {100.0,2000.0,3000.0};
        int qty2[] = {1,2,3};
        OrderProcessor2 p = new OrderProcessor2();
        System.out.println("Resultado Exercicio 4 : "  + p.calculateTotal(prices2,qty2));

        SpringApplication.run(Aula01Application.class, args);
    }

}
