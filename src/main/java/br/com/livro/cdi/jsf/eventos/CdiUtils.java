package br.com.livro.cdi.jsf.eventos;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import javax.enterprise.inject.spi.BeanManager;
import javax.naming.Context;
import javax.naming.InitialContext;

public class CdiUtils {

    private static final String BEAN_MANAGER_JNDI_NAME_JEE = "java:comp/BeanManager";
    private static final String BEAN_MANAGER_JNDI_NAME_NON_JEE = "java:comp/env/BeanManager";

    private Logger logger = LoggerFactory.getLogger(CdiUtils.class);

    public BeanManager getBeanManager() {
        try {
            Context ctx = new InitialContext();
            BeanManager beanManager = (BeanManager) ctx.lookup(BEAN_MANAGER_JNDI_NAME_JEE);
            return beanManager;
        } catch (Exception e) {
            logger.error("Falha ao buscar o BeanManager via lookup", e);
            return null;
        }
    }
}
