<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Niepoprawny login lub haslo!</h1>
        <br>
        
        <a href="/Komputery/control/login">Powrót do logowania</a>
        
        <hr>
        <%
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
        %>
    </body>
</html>
