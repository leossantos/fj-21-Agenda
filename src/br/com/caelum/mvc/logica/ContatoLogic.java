package br.com.caelum.mvc.logica;

import br.com.caelum.agenda.jdbc.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;

public class ContatoLogic implements Logica{
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

        if (req.getParameter("id") == null){
            return "/WEB-INF/jsp/adiciona-contato.jsp";
        }
        else{
            long id = Long.parseLong(req.getParameter("id"));
            Contato contato = new Contato();
            contato.setId(id);

            // busca a conexão pendurada na requisição
            Connection connection = (Connection) req.getAttribute("conexao");
            // passe a conexão no construtor
            ContatoDao dao = new ContatoDao(connection);
            System.out.println("Buscando Contato");
            contato = dao.busca(contato);
            req.setAttribute("contato", contato);
            return "/WEB-INF/jsp/alterar-contato.jsp";
        }




    }
}
