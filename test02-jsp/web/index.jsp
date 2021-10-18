<%-- 
    Document   : data
    Created on : 2021-10-11, 12:18:12
    Author     : UL0246827
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="java.text.SimpleDateFormat" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Testowy JSP Page</title>
    </head>
    <body>
        <form action="login.jsp"><input type="submit" value="Logowanie"></form>
        
        
        <h1>Hello World!</h1><br>
        <h1><% out.println("B LA BLAB LA"); %></h1>
        
        <br>
        Dzisiaj jest <%= new Date() %>
        <br><hr><br>
        <%
        String ciag = new String();
        SimpleDateFormat prostaData = new SimpleDateFormat();
        %>
        
        <br><br>
        Przekazywanie danych przez serwlet w srodku <a href="newformularz.jsp">tutaj</a>
        
        <br><hr><br>
        <h2>
            Wynik mnozenia: 
            <%! int wynik = 0; %>
            <% wynik = 2*5; %>
            <%= wynik %>
        </h2>
        <hr>
        <TABLE>
            <% for(int i = 0; i<5; i++) {%>
            <TR>
                <TD>Nr</TD>
                <TD><%= i+1 %></TD>
            </TR>
            <% } %>
        </TABLE>
        
        <br><hr><br>
        <%
            out.println("<b>Tabliczka mnozenia</b>");
            out.println("<br><br>");
            
            int z = 0;
            
            for(int i = 1; i <= 9; i++){
                out.println("<TABLE>");
                for(int j = 1; j <= 9; j++){
                    z = i * j;
                    out.println(i+" x "+j+" = "+z);
                    out.println("<br>");
                }
                out.println("</TABLE>");
                out.println("<br>");
            }
        %>
        
        <br><hr><br>
        <%@ page language="java" %>
        Wprowadzanie wartosci<br>
        <form ACTION="widok.jsp">
            <input type="text" name="w1"><br>
            <input type="text" name="w2"><br>
            <input type="submit" value="ok">
        </form>
        
        <br><hr><center><i><sup>by Wolfik</sup></i></center>
    </body>
</html>
