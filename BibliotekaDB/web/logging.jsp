<%-- 
    Document   : logging
    Created on : 2021-11-22, 12:34:04
    Author     : UL0246827
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logowanie</title>
    </head>
    <body>
        <h1>LOGOWANIE</h1>
        <br>
        <form name="loginForm" method="post" action="LogowanieServ.java">
            login: 
            <input type="text" name="login"><br>
            haslo: 
            <input type="password" name="password"><br>
            <input type="submit" value="Zaloguj">
        </form>
    </body>
</html>
