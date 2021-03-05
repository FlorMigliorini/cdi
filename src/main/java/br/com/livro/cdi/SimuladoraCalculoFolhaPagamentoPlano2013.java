package br.com.livro.cdi;

import static br.com.livro.cdi.qualificadores.PlanoDeCargos.VERSAO_2013;
import br.com.livro.cdi.qualificadores.Simulador;
import java.util.List;

@Simulador(planoDeCargos = VERSAO_2013)
public class SimuladoraCalculoFolhaPagamentoPlano2013 implements CalculadoraFolhaPagamento {

    @Override
    public Folha calculaFolha(List<Funcionario> funcionarios) {
        System.out.println("Simulação com plano de 2013");
        return null;
    }

}
