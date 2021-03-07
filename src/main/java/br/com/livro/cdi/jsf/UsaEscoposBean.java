package br.com.livro.cdi.jsf;

import java.util.Map;
import javax.inject.Inject;

public class UsaEscoposBean {

    @Inject
    @ApplicationMap
    private Map<String, Object> applicationMap;

    @Inject
    @SessionMap
    private Map<String, Object> sessionMap;

    @Inject
    @RequestMap
    private Map<String, Object> requestMap;

    @Inject
    @RequestParameterMap
    private Map<String, String> requestParameterMap;

    public void teste() {
        System.out.println("applicationMap >> " + applicationMap);
        System.out.println("sessionMap >> " + sessionMap);
        System.out.println("requestMap >> " + requestMap);
        System.out.println("requestParameterMap >> " + requestParameterMap);

    }
}
