package br.com.caelum.agenda.filtro;

import br.com.caelum.agenda.jdbc.ConnectionFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebFilter("/*")
public class FiltroConexao implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        try {
            Connection connection = new ConnectionFactory()
                    .getConnection();

            // pendurando a connection na requisição
            request.setAttribute("conexao", connection);

            chain.doFilter(request, response);

            connection.close();
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
