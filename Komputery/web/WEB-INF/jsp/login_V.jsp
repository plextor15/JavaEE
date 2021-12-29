<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        
        <h1>Logowanie</h1>
        <form:form method="POST" modelAttribute="login_user" action="/Komputery/control/login/check">
            <table border="1" >
                <tr>
                    <td><form:label path="username">Username</form:label></td>
                    <td><form:input path="username"/></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><form:input path="password"/></td>
                </tr>
            </table>
            <input type="submit" value="zaloguj"/>
        </form:form>
            
        <h1>Rejestracja</h1>
    </body>
</html>
