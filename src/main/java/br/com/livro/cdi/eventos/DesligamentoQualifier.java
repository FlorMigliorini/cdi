package br.com.livro.cdi.eventos;

import javax.enterprise.util.AnnotationLiteral;

public abstract class DesligamentoQualifier extends AnnotationLiteral<Desligamento> implements Desligamento {

    private TipoDesligamento tipoDesligamento;

    public DesligamentoQualifier(TipoDesligamento tipoDesligamento) {
        this.tipoDesligamento = tipoDesligamento;
    }

    public TipoDesligamento value() {
        return tipoDesligamento;
    }
}
