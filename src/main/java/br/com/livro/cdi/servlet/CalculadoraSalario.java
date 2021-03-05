package br.com.livro.cdi.servlet;

import br.com.livro.cdi.CalculadoraDeSalarios;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calcular-salario")
public class CalculadoraSalario extends HttpServlet {

    @Inject
    private CalculadoraDeSalarios calculadoraDeSalarios;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.getOutputStream().print("Calculo de salário: " + calculadoraDeSalarios.getClass());
    }
}
