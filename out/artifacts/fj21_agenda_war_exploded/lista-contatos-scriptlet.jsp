<%--
  Created by IntelliJ IDEA.
  User: leonardo
  Date: 07/07/19
  Time: 01:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*,
                  br.com.caelum.agenda.jdbc.dao.*,
                  br.com.caelum.agenda.modelo.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<html>
<head>
    <title>Contatos</title>
</head>
<body>
    <table>
        <tr>
            <td>Nome</td>
            <td>Email</td>
            <td>Endereço</td>
            <td>Data de Nascimento</td>
        </tr>
        <%
            ContatoDao dao = new ContatoDao();
            List<Contato> contatos = dao.getLista();
            SimpleDateFormat p = new SimpleDateFormat("dd/MM/yyyy");

            for (Contato contato : contatos ) {
        %>
        <tr>
            <td><%=contato.getNome() %></td>
            <td><%=contato.getEmail() %></td>
            <td><%=contato.getEndereco() %></td>
            <td><%=p.format(contato.getDataNascimento().getTime()) %></td>
        </tr>
        <%
            }
        %>
    </table>

</body>
</html>
