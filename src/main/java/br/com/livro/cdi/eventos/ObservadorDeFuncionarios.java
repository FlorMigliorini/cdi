package br.com.livro.cdi.eventos;

import br.com.livro.cdi.Funcionario;
import com.sun.org.slf4j.internal.Logger;
import javax.annotation.Resource;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Topic;

@Stateless
public class ObservadorDeFuncionarios {

    @Inject
    private Logger logger;

    public void observaFuncionario(
            @Observes Funcionario funcionario) {
        logger.info("Recebendo evento do funcionario {}",
                funcionario);
    }

//    @Inject
//    private JMSContext jmsContext;
//
//    @Resource(mappedName = "jms/demissaoTopic")
//    private Topic topicoDemissao;
//
//    @Asynchronous
//    public void notificaAgenciaDeEmprego(@Observes @Desligamento(TipoDesligamento.DEMISSAO) Funcionario funcionario, Logger logger) throws Exception {
//        logger.info("Enviando demissão do funcionario {} para agencia de empregos", funcionario);
//        jmsContext.createProducer().send(topicoDemissao, funcionario);
//    }
}
