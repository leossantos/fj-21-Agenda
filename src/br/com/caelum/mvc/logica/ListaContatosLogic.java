package br.com.caelum.mvc.logica;

import br.com.caelum.agenda.jdbc.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.util.List;

public class ListaContatosLogic implements Logica {

    public String executa(HttpServletRequest req, HttpServletResponse res)
            throws Exception {

        // busca a conexão pendurada na requisição
        Connection connection = (Connection) req.getAttribute("conexao");
        // passe a conexão no construtor
        ContatoDao dao = new ContatoDao(connection);
        List<Contato> contatos = dao.getLista();

        req.setAttribute("contatos", contatos);

        return "/WEB-INF/jsp/lista-contatos.jsp";
    }
}

