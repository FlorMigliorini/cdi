package br.com.livro.cdi;

import java.util.List;

public class SimuladoraCalculoFolhaPagamento implements
        CalculadoraFolhaPagamento {

    @Override
    public Folha calculaFolha(List<Funcionario> funcionarios) {
        System.out.println("Apenas uma simula��o da folha de pagamentos");
        return null;
    }

}
