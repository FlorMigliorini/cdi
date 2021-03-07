package br.com.livro.cdi.eventos;

import br.com.livro.cdi.Funcionario;
import static br.com.livro.cdi.eventos.TipoDesligamento.APOSENTADORIA;
import static br.com.livro.cdi.eventos.TipoDesligamento.DEMISSAO;
import java.lang.annotation.Annotation;
import javax.annotation.PostConstruct;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class GestorFuncionarioBean {

    private Funcionario funcionario;
    private TipoDesligamento tipoDesligamento;

    @Inject
    private Event<Funcionario> eventoFuncionario;

    @Inject
    private Event<Funcionario> eventoDesligamento;

    @PostConstruct
    public void init() {
        funcionario = new Funcionario();
    }

    public TipoDesligamento[] tiposDesligamento() {
        return TipoDesligamento.values();
    }

    public void cadastraFuncionario() {
        //salva funcionario no banco
        System.out.println("####>> cadastrar usu�rio...");
        eventoFuncionario.fire(funcionario);
        System.out.println("####>> usu�rio cadastrado!");
    }

    public void desligarFuncionario() {

        Annotation qualificador = null;
        if (tipoDesligamento == TipoDesligamento.APOSENTADORIA) {
            //faz a l�gica de aposentadoria
            qualificador = new DesligamentoQualifier(APOSENTADORIA) {
            };
        } else if (tipoDesligamento == TipoDesligamento.DEMISSAO) {
            qualificador = new DesligamentoQualifier(DEMISSAO) {
            };
        }

        Event<Funcionario> eventoQualificado = eventoDesligamento.select(qualificador);

        System.out.println("####>> desligar usu�rio...");

        eventoQualificado.fire(funcionario);

        System.out.println("####>> usu�rio desligado!");

    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public TipoDesligamento getTipoDesligamento() {
        return tipoDesligamento;
    }

    public void setTipoDesligamento(TipoDesligamento tipoDesligamento) {
        this.tipoDesligamento = tipoDesligamento;
    }
}
