package br.com.livro.cdi.controllers;

import br.com.livro.cdi.CalculadoraFolhaPagamento;
import br.com.livro.cdi.Folha;
import br.com.livro.cdi.Funcionario;
import br.com.livro.cdi.FuncionarioBuilder;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.inject.Inject;

public class CalculadoraFolhaBean implements Serializable {

    private Folha folha;
    private FuncionarioBuilder builder;
    private List<Funcionario> funcionarios;
    private double salarioFucionario;

    @Inject
    private Conversation conversarion;

    @Inject
    private CalculadoraFolhaPagamento calculadoraFolha;

    @PostConstruct
    public void init() {
        builder = new FuncionarioBuilder();
//        funcionarios = new ArrayList<>();

    }

    public void iniciaConversacao() {
        if (conversarion.isTransient()) {
            conversarion.begin();
        }
    }

    public void terminaConversacao() {
        if (!conversarion.isTransient()) {
            conversarion.end();
        }
    }

    public void adicionaFuncionario() {
        Funcionario funcionario = builder.comSalarioBaseDe(salarioFucionario).build();
        getFuncionarios().add(funcionario);
    }

    public void calcularFolha() {
        folha = calculadoraFolha.calculaFolha(getFuncionarios());
    }

    public double getSalarioFuncionario() {
        return salarioFucionario;
    }

    public void setSalarioFuncionario(double salarioFuncionario) {
        this.salarioFucionario = salarioFuncionario;
    }

    public Folha getFolha() {
        return folha;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }
}
