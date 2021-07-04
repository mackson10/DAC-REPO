<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>saygoodbye.jsp</title>
        <link rel="stylesheet" type="text/css" href="app.css">
    </head>
    <body>
        <div class="conteudo">
            <jsp:useBean id="myBean" class="hello.MessageBean"/>
            <h1>É só falar:</h1>
            <img src="imagens/conversas.png" style="width: 600px;" alt="conversas"/>

            <% String lang = request.getParameter("lang"); %>
            <jsp:setProperty name="myBean" property="byeMsg" value="<%=lang%>"/>
            <h3><jsp:getProperty name="myBean" property="byeMsg"/> <%=request.getParameter("nome")%>!</h3>
            <br/><br/><a href="#" onclick="window.history.back();">Voltar</a>
        </div>
    </body>
</html>
