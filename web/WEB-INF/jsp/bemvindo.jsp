<%--
  Created by IntelliJ IDEA.
  User: leonardo
  Date: 07/07/19
  Time: 01:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Bem vindo</title>
</head>
<body>

    <c:import url="suporte/cabecalho.jsp" />

    <%-- comentário em JSP aqui: nossa primeira página JSP --%>
    Bem vindo ao sistema de agenda do FJ-21! <br>
    Desenvolvido por Leonardo<br>

    <a href="mvc?logica=BuscaContatoLogic">Adicionar Contato</a>
    <a href="mvc?logica=ListaContatosLogic">Listar Contatos</a>
    <c:import url="suporte/rodape.jsp" />
</body>
</html>
