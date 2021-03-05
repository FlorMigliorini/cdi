package br.com.livro.cdi;

import java.util.List;

public interface CalculadoraFolhaPagamento {
    
    Folha calculaFolha(List<Funcionario> funcionarios);
    
}
