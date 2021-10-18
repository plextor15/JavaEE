<%-- 
    Document   : przekazanie
    Created on : 2021-10-18, 12:19:49
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
        <h1>Witaj</h1><br>
        <%
        String name = (String)session.getAttribute("imie");
        int ileRazy = (int)session.getAttribute("ileRazy");
        %>
        <%= name %>
        <br><br>
        Strone wyswietlono juz <%= ileRazy %> w ciagu tej sesji
        <% ileRazy++;
        session.setAttribute("ileRazy", ileRazy); %>
        
        <br><a href="widok.jsp"> EXIT NOT WORKING</a>
    </body>
</html>
