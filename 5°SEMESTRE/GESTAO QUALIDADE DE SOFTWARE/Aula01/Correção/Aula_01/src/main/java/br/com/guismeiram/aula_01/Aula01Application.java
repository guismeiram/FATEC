package br.com.guismeiram.aula_01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import static br.com.guismeiram.aula_01.Projeto_01.CalculoSalario.calcularDescontoSalarial;


@SpringBootApplication
public class Aula01Application {

    public static void main(String[] args) {

        double salario = 5000;
        double salarioLiquido = calcularDescontoSalarial(salario);
        System.out.println("Salario Liquido: " + salarioLiquido);
        SpringApplication.run(Aula01Application.class, args);
    }

}
