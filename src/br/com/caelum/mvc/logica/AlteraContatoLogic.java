package br.com.caelum.mvc.logica;

import br.com.caelum.agenda.jdbc.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AlteraContatoLogic implements  Logica{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {


        // buscando os parâmetros no request
        Long id = Long.parseLong(req.getParameter("id"));
        String nome = req.getParameter("nome");
        String endereco = req.getParameter("endereco");
        String email = req.getParameter("email");
        String dataEmTexto = req.getParameter("dataNascimento");
        Calendar dataNascimento = null;

        // fazendo a conversão da data
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
            dataNascimento = Calendar.getInstance();
            dataNascimento.setTime(date);
        } catch (ParseException e) {
            System.out.println("Erro de conversão da data");
        }

        // monta um objeto contato
        Contato contato = new Contato();
        contato.setId(id);
        contato.setNome(nome);
        contato.setEndereco(endereco);
        contato.setEmail(email);
        contato.setDataNascimento(dataNascimento);

        // salva o contato
        // busca a conexão pendurada na requisição
        Connection connection = (Connection) req.getAttribute("conexao");
        // passe a conexão no construtor
        ContatoDao dao = new ContatoDao(connection);
        dao.altera(contato);

        return "mvc?logica=ListaContatosLogic";
    }
}
