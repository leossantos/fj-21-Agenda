package br.com.caelum.agenda.jdbc.dao;


import br.com.caelum.agenda.modelo.Contato;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ContatoDao {
    private Connection connection;

    public ContatoDao(Connection connection) {
        this.connection = connection;
    }

    public void adiciona(Contato contato) {
        String sql = "insert into contatos (nome,email,endereco,dataNascimento) values (?,?,?,?)";

        try {
            // prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);

            // seta os valores
            stmt.setString(1,contato.getNome());
            stmt.setString(2,contato.getEmail());
            stmt.setString(3,contato.getEndereco());
            stmt.setDate(4, new Date(
                    contato.getDataNascimento().getTimeInMillis()));

            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public List<Contato> getLista() {
        try {
            List<Contato> contatos = new ArrayList<>();
            PreparedStatement stmt = this.connection.
                    prepareStatement("select * from contatos");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // criando o objeto Contato
                Contato contato = criaContato(rs);

                // adicionando o objeto à lista
                contatos.add(contato);
            }
            rs.close();
            stmt.close();
            return contatos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Contato criaContato(ResultSet rs) throws SQLException {
        Contato contato = new Contato();

        contato.setId(rs.getLong("id"));
        contato.setNome(rs.getString("nome"));
        contato.setEmail(rs.getString("email"));
        contato.setEndereco(rs.getString("endereco"));

        // montando a data através do Calendar
        Calendar data = Calendar.getInstance();
        data.setTime(rs.getDate("dataNascimento"));
        contato.setDataNascimento(data);


        return contato;
    }

    public void exclui(Contato contato) {
        String sql = "delete from contatos where id = (?)";

        try {
            // prepared statement para deleção
            PreparedStatement stmt = connection.prepareStatement(sql);

            // pegando o id
            stmt.setLong(1, contato.getId());

            // executa
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public  Contato busca(Contato contato){

        String sql = "select * from contatos where id = ?";

        try{

            // prepared statement para busca
            PreparedStatement stmt = connection.prepareStatement(sql);

            //pegando o id
            stmt.setLong(1, contato.getId());

            //executa

            ResultSet rs = stmt.executeQuery();


            // criando o objeto Contato
            rs.next();

            contato = criaContato(rs);



            //Fechar processos
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return contato;
    }

    public void altera(Contato contato) {
        String sql = "update contatos SET nome = ?, email = ? , endereco = ?, datanascimento = ? WHERE id = ?";

        try{
            // prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);

            //Coloca os dados nas queries
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getEmail());
            stmt.setString(3, contato.getEndereco());
            stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
            stmt.setLong(5, contato.getId());

            // executa
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro na alteração");
        }

    }
}
