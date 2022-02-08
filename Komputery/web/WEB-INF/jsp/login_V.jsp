<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <style>
        .rec01{
            position: absolute;
            width: 799px;
            height: 145px;
            background-image: linear-gradient(to right, #1f1f1f, #004466);
            border: 7px solid #00FF19;
            box-sizing: border-box;
        }
        h2 {
            position: absolute;
            width: 800px;
            height: 80px;
            font-family: Courier, Monospace;
            font-size: 80px;
            line-height: 20px;
            display: flex;
            align-items: center;
            text-align: center;
            color: #DDDDDD;
            /*text-stroke: 4px solid #00A0E4;*/
        }
        #tekst {
            position: fixed;
            bottom: 400px;
            right: 400px;
            
            text-indent: 150px;
            text-align: justify;
            letter-spacing: 7px;
            color: white;
        }
        body {
            background-color: #404040; /*jakby nie zadzialalo to staly kolor*/
            background-image: linear-gradient(to bottom right, #2e2e2e 65%, #737373 125%);
            background-repeat: no-repeat;
            background-attachment: fixed;
        }
        
        h1 {
            font-weight: bold;
            color: #DDDDDD;
        }
        h3 {color: #DDDDDD;}
        h4 {color: #DDDDDD;}
        h5 {color: #DDDDDD;}
        h6 {color: #DDDDDD;}
        a {
            color: #6FC861;
            font-weight: bold;
        }
    </style>
    <body>
        <h1>Logowanie</h1>
        <form:form method="POST" modelAttribute="login_user" action="/Komputery/control/login/tocheck">
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
            
        <a href="/Komputery/control/login/register"><h1>Rejestracja</h1></a>
    </body>
</html>
