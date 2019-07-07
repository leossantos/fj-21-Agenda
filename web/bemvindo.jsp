<%--
  Created by IntelliJ IDEA.
  User: leonardo
  Date: 07/07/19
  Time: 01:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bem vindo</title>
</head>
<body>
    <%-- comentário em JSP aqui: nossa primeira página JSP --%>

    <%
        String mensagem = "Bem vindo ao sistema de agenda do FJ-21!";
    %>
    <% out.println(mensagem); %>

    <br />

    <%
        String desenvolvido = "Desenvolvido por Leonardo";
    %>
    <%= desenvolvido %>

    <br />

    <%
        System.out.println("Tudo foi executado!");
    %>
</body>
</html>
