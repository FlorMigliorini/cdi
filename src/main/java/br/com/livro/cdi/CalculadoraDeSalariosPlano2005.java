package br.com.livro.cdi;

import br.com.livro.cdi.interceptador.Auditavel;
import java.util.Calendar;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

public class CalculadoraDeSalariosPlano2005 implements CalculadoraDeSalarios {

    @Inject
    private Logger logger;

    public CalculadoraDeSalariosPlano2005() {
        System.out.println("Iniciando Calculadora de sal?rios...");
    }

    @PostConstruct
    public void init() {
        System.out.println("Calculadora de sal?rios pronta!");
    }

    @Override
    @Auditavel
    public double calculaSalario(Funcionario funcionario) {
        double salario = funcionario.getCargo().getSalarioBase();
        Escolaridade escolaridadeFuncionario = funcionario.getEscolaridade();
        Escolaridade escolaridadeCargo
                = funcionario.getCargo().getEscolaridadeDesejada();

        //se o funcion?rio tem escolaridade inferior ? esperada para o cargo
        if (escolaridadeFuncionario.compareTo(escolaridadeCargo) < 0) {
            salario = salario * 0.8;
        } //se o funcion?rio tem escolaridade superior ? esperada para o cargo
        else if (escolaridadeFuncionario.compareTo(escolaridadeCargo) > 0) {
            salario = salario * 1.2;
        }

        int anoAtual = getAnoAtual();
        int anoAdmissao = funcionario.getAnoAdmissao();

        //d? 1% de aumento para cada ano trabalhado na empresa
        double anosTrabalhados = anoAtual - anoAdmissao;
        double aumentoAntiguidade = anosTrabalhados / 100;
        salario = salario * (1 + aumentoAntiguidade);

        //se tem mais de 5 anos na empresa tem aumento de 10%
        if (anosTrabalhados > 5) {
            salario = salario * 1.1;
        }

        return salario;
    }

    private int getAnoAtual() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    @Override
    public void setTabelaDeReferenciaSalarial(TabelaDeReferenciaSalarial tabela) {
    }

}
