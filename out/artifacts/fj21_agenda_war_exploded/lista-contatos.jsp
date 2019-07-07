<%--
  Created by IntelliJ IDEA.
  User: leonardo
  Date: 07/07/19
  Time: 02:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<html>
<head >
    <meta charset="UTF-8">
    <title>Listar Contatos</title>
</head>
<body>
    <c:import url="cabecalho.jsp" />
    <!-- cria o DAO -->
    <jsp:useBean id="dao" class="br.com.caelum.agenda.jdbc.dao.ContatoDao"/>
    <table>
            <tr>
                <td>Numero</td>
                <td>Nome</td>
                <td>Email</td>
                <td>Endereço</td>
                <td>Data de Nascimento</td>
            </tr>
        <!-- percorre contatos montando as linhas da tabela -->
        <c:forEach var="contato" items="${dao.lista}" varStatus="id">
            <tr bgcolor="#${id.count % 2 == 0 ? 'eeeeee' : 'ffffff' }">
                <td>${id.count}</td>
                <td>${contato.nome}</td>
                <td>
                    <c:choose>
                        <c:when test="${not empty contato.email}">
                            <a href="mailto:${contato.email}">${contato.email}</a>
                        </c:when>
                        <c:otherwise>
                            E-mail não informado
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>${contato.endereco}</td>
                <td><fmt:formatDate value="${contato.dataNascimento.time}"
                                    pattern="dd/MM/yyyy" /></td>
            </tr>
        </c:forEach>
    </table>





    <c:import url="rodape.jsp" />
</body>
</html>
