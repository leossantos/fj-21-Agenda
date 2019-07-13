package br.com.caelum.agenda.filtro;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class FiltroTempoDeExecucao implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        long tempoInicial = System.currentTimeMillis();

        chain.doFilter(request, response);

        long tempoFinal = System.currentTimeMillis();
        String uri = ((HttpServletRequest)request).getRequestURI();
        String parametros = ((HttpServletRequest) request)
                .getParameter("logica");
        System.out.println("Tempo da requisicao de " + uri
                + "?logica="
                + parametros + " demorou (ms): "
                + (tempoFinal - tempoInicial));


    }
}
