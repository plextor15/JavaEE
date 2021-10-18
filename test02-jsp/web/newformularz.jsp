<%-- 
    Document   : newformularz
    Created on : 2021-10-18, 13:15:32
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
        <h1>Hello World!</h1>
        <form action="Servlecik" method="post">
            <p> Wprowadzanei: </p>
            <input type="text" name="newLogin">
            <input type="text" name="newPass">
            <input type="submit" value="Wyslij" />
        </form>

    </body>
</html>
