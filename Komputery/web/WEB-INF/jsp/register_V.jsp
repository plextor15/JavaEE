<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        
        <title>Rejestracja</title>
    </head>
    <body>
        <h1>Rejestracja użytkownika</h1>
        ${msg}
        <form action="register" method="post">
            <pre>
                Id: <input type="text" name="id" />
                Username: <input type="text" name="username" />
                Password: <input type="password" name="password" />
                <input type="submit" value="Create" />
            </pre>
        </form>
        ${msg}
        
        <a href="/Komputery/control/login">Powrót</a>
    </body>
</html>
