package br.com.livro.cdi;

public interface CalculadoraDeSalarios {

    double calculaSalario(Funcionario funcionario);

    void setTabelaDeReferenciaSalarial(TabelaDeReferenciaSalarial tabela);

}
