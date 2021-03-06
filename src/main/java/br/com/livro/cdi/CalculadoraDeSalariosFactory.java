package br.com.livro.cdi;

import java.util.ResourceBundle;

public class CalculadoraDeSalariosFactory {

    private ResourceBundle bundle = ResourceBundle.getBundle("dependencias");

    private <T> T criaInstancia(Class<T> classe) {
        String nomeDaClasse = bundle.getString(classe.getSimpleName());
        try {
            Class<?> clazz = Class.forName(nomeDaClasse);
            return clazz.asSubclass(classe).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public CalculadoraDeSalarios criaCalculadora() {
        TabelaDeReferenciaSalarial pisosSalariais = criaInstancia(TabelaDeReferenciaSalarial.class);
        CalculadoraDeSalarios calculadora = criaInstancia(CalculadoraDeSalarios.class);
        calculadora.setTabelaDeReferenciaSalarial(pisosSalariais);
        return calculadora;
    }

}
