package br.com.caelum.mvc.logica;

import br.com.caelum.agenda.jdbc.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;

public class RemoveContatoLogic implements Logica {

    public String executa(HttpServletRequest req, HttpServletResponse res)
            throws Exception {

        long id = Long.parseLong(req.getParameter("id"));

        Contato contato = new Contato();
        contato.setId(id);

        // busca a conexão pendurada na requisição
        Connection connection = (Connection) req.getAttribute("conexao");
        // passe a conexão no construtor
        ContatoDao dao = new ContatoDao(connection);
        dao.exclui(contato);
        System.out.println("Excluindo contato... ");

        return "mvc?logica=ListaContatosLogic";
    }

}