<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Błąd logowania</title>
    </head>
    <style>
        #zlybox {
            padding: 10px;
            background-color: #ff1919;
            border: 10px solid #ff0000;
        }
        #tekst {
            position: fixed;
            bottom: 400px;
            right: 400px;
            
            text-indent: 150px;
            text-align: justify;
            letter-spacing: 7px;
            color: #730000;
        }
        #grad01 {
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
    <body id="grad01">
        <div id="zlybox">
            
                <h1 style="text-align:center;"><b>Niepoprawny login lub hasło!</b></h1>
            
        </div>
        <br><br>
        
        <a href="/Komputery/control/login"><h2>Powrót do logowania</h2></a>
        
        <hr>
        <%
            /*
            out.println("<h1>Testing</h1>");
            
            int x;
            int y;
            String z;
            
            x = (int)session.getAttribute("user_type");
            //y = (int)session.getAttribute("ktoryZKolei");
            //z = (String)session.getAttribute("ktoryZKolei");
            
            for(int i=0; i < 10; i++){
                out.println(x + "\n");
            }
            
            //out.println("<br>" + session.getAttribute("ktoryZKolei") + "<br>");
            */
        %>
    </body>
</html>
