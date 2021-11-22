<%-- 
    Document   : userpage
    Created on : 2021-11-22, 13:26:35
    Author     : UL0246827
--%>


<%@page import="BibliotekaPack.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Userpage</title>
    </head>
    <body>
        <%
        User LoggedIn = (User)session.getAttribute("LoggedInUser");
        %>
        <h1>Witaj <%= LoggedIn.Name %>!</h1><br>
        
        
        Wyporzyczone ksiazki:
    </body>>
</html>
