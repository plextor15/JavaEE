<%-- 
    Document   : widok
    Created on : 2021-10-11, 13:09:37
    Author     : UL0246827
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Widok</title>
    </head>
    <body>
        <%! int wynik; int wart1; int wart2;%>
        
        <%
            wart1 = Integer.parseInt(request.getParameter("w1"));
            wart2 = Integer.parseInt(request.getParameter("w2"));
            
            wynik = wart1 + wart2;
            out.println("Wynik dodawania to "+wynik);
            out.println("<br>");
            
            wynik = wart1 * wart2;
            out.println("Wynik mnozenia to "+wynik);
        %>
        
        <hr>
        <%
        String name="Adam";
        int ileRazy = 0;
        session.setAttribute("imie", name);
        session.setAttribute("ileRazy", ileRazy);
        %>
        <a href="przekazanie.jsp"> przekazanie</a>
        
        <form action="index.jsp">
            <input type="submit" value="powrot">
        </form>
        
        
    </body>
</html>
