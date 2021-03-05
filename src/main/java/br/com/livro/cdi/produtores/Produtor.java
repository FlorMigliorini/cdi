package br.com.livro.cdi.produtores;

import br.com.livro.cdi.CalculadoraFolhaPagamento;
import br.com.livro.cdi.CalculadoraFolhaPagamentoReal;
import com.sun.org.slf4j.internal.LoggerFactory;
import java.util.logging.Logger;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

public class Produtor {

    public CalculadoraFolhaPagamento criaUmaCalculadora() {
        System.out.println("Produtor.criaUmaCalculadora()");
        return new CalculadoraFolhaPagamentoReal();
    }

//    @Produces
//    public Logger criaLogger(InjectionPoint injectionPoint) {
//        return LoggerFactory.getLogger(injectionPoint.getMember().getDeclaringClass());
//    }
}
