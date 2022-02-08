<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        
        <title>Rejestracja</title>
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
