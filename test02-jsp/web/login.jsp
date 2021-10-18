<%-- 
    Document   : login
    Created on : 2021-10-11, 13:30:38
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
        <form ACTION="spr_login.jsp">
            login: 
            <input type="text" name="login"><br>
            haslo: 
            <input type="text" name="pass"><br>
            <input type="submit" value="Zaloguj">
        </form>
    </body>
</html>
