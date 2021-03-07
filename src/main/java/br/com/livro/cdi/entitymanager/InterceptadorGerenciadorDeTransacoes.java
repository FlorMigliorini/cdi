package br.com.livro.cdi.entitymanager;

import javax.enterprise.inject.Vetoed;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

@Vetoed
public class InterceptadorGerenciadorDeTransacoes {

    @Inject
    private EntityManager entityManager;

    @AroundInvoke
    public Object gerenciaTransacao(InvocationContext context) throws Exception {

        EntityTransaction tx = null;
        try {
            //em ambiente JTA apenas o getTransaction já lança exceção
            tx = entityManager.getTransaction();
            tx.begin();
            Object retorno = context.proceed();
            tx.commit();
            return retorno;
        } catch (RuntimeException e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        }

    }
}
