<%--
  Created by IntelliJ IDEA.
  User: leonardo
  Date: 08/07/19
  Time: 22:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="caelum" %>
<html>
    <head>
        <title>Alterar Contato</title>
        <link href="css/jquery-ui.css" rel="stylesheet" type="text/css">
        <script src="js/jquery.js"></script>
        <script src="js/jquery-ui.js"></script>
    </head>
    <body>
        <c:import url="suporte/cabecalho.jsp" />

        <h1>Alterar Contato</h1>
        <hr />
        <form action="mvc?logica=AlteraContatoLogic" method="POST">
            ID: <input type="text" name="id" value="${contato.id}" readonly="true"> <br>
            Nome: <input type="text" name="nome" value= "${contato.nome}"/><br />
            E-mail: <input type="text" name="email" value="${contato.email}"/><br />
            Endereço: <input type="text" name="endereco" value="${contato.endereco}"/><br />
            Data Nascimento:<caelum:campoData id="dataNascimento" /><br />

            <input type="submit" value="Gravar"/>
        </form>


        <c:import url="suporte/rodape.jsp" />
    </body>
</html>
