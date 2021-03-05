package br.com.livro.cdi.qualificadores;

import javax.enterprise.util.AnnotationLiteral;

public class SimuladorQualifier extends AnnotationLiteral<Simulador> implements Simulador {

    private PlanoDeCargos planoDeCargos;
    private boolean planoAprovado;
    private boolean enviarNotificacao;

    public SimuladorQualifier() {
        this(PlanoDeCargos.VERSAO_2005, true, true);
    }

    public SimuladorQualifier(PlanoDeCargos planoDeCargos, boolean planoAprovado, boolean enviarNotificacao) {
        this.planoDeCargos = planoDeCargos;
        this.planoAprovado = planoAprovado;
        this.enviarNotificacao = enviarNotificacao;
    }

    @Override
    public PlanoDeCargos planoDeCargos() {
        return planoDeCargos;
    }

    @Override
    public boolean planoAprovado() {
        return planoAprovado;
    }

    @Override
    public boolean enviarNotificacao() {
        return enviarNotificacao;
    }

}
