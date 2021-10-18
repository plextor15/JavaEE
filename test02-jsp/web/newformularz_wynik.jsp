<%-- 
    Document   : newformularz_wynik
    Created on : 2021-10-18, 13:31:28
    Author     : UL0246827
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> <%=request.getSession().getAttribute("daneZSerwletu") %> </h1>
    </body>
</html>
