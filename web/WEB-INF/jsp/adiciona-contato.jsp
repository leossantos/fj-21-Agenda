<%--
  Created by IntelliJ IDEA.
  User: leonardo
  Date: 07/07/19
  Time: 01:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="caelum" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Adicionar Contato</title>
    <link href="../../css/jquery-ui.css" rel="stylesheet" type="text/css">

    <script src="../../js/jquery.js"></script>
    <script src="../../js/jquery-ui.js"></script>

</head>
<body>
    <c:import url="suporte/cabecalho.jsp" />
    <h1>Adiciona Contatos</h1>
    <hr />
    <form action="mvc?logica=AdicionaContatoLogic" method="POST">
        Nome: <input type="text" name="nome" /><br />
        E-mail: <input type="text" name="email" /><br />
        Endereço: <input type="text" name="endereco" /><br />
        Data Nascimento:<caelum:campoData id="dataNascimento" /><br />

        <input type="submit" value="Gravar"/>
    </form>
    <c:import url="suporte/rodape.jsp"/>
</body>
</html>