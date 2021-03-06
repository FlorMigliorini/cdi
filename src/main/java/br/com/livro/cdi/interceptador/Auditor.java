package br.com.livro.cdi.interceptador;

import java.lang.reflect.Method;
import java.util.logging.Logger;
import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@Auditavel
@Priority(Interceptor.Priority.APPLICATION)
public class Auditor {

    @Inject
    private Logger logger;

    @AroundInvoke
    public Object auditar(InvocationContext context) throws Exception {

        //faz processamento antes
        logger.info("faz processamento anterior");

        Method method = context.getMethod();
        Object target = context.getTarget();
        Object[] params = context.getParameters();

        logger.info(String.format("auditando o m�todo: '%s' "
                + "do objeto: '%s' "
                + "com os par�metros: '%s'", method, target, params));

        //chama o m�todo orignal
        logger.info("chama m�todo original");
        Object retorno = context.proceed();

        //faz processamento posterior
        logger.info("faz processamento posterior");

        return retorno;
    }
}
