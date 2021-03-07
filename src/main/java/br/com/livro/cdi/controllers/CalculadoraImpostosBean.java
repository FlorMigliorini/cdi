package br.com.livro.cdi.controllers;

import br.com.livro.cdi.CalculadoraDeImpostos;
import br.com.livro.cdi.Funcionario;
import br.com.livro.cdi.FuncionarioBuilder;
import br.com.livro.cdi.esteriotipo.CalculadoraBean;
import javax.annotation.PostConstruct;
import javax.inject.Inject;


@CalculadoraBean
public class CalculadoraImpostosBean {

    private static final long serialVersionUID = 1L;

    @Inject
    private CalculadoraDeImpostos calculadoraImpostos;

    private double salarioBase;
    private double imposto;

    public CalculadoraImpostosBean() {
        System.out.println("Instanciando a CalculadoraImpostosBean...");
    }

    @PostConstruct
    public void ok() {
        System.out.println("CalculadoraImpostosBean pronta.");
    }

    public void calculaImposto() {

        Funcionario funcionario = new FuncionarioBuilder()
                .comSalarioBaseDe(salarioBase)
                .build();

        System.out.println("Efetuando o cálculo.");

        System.out.println("Salário base: " + salarioBase);

        //a calculadora de IR usa outra classe para calcular o salário
        imposto = calculadoraImpostos.calculaImpostoDeRenda(funcionario);

        System.out.println("valor do imposto: " + imposto);
        System.out.println("Fim.");
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public double getImposto() {
        return imposto;
    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }
}
