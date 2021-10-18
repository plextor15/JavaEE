<%-- 
    Document   : spr_login
    Created on : 2021-10-11, 13:32:51
    Author     : UL0246827
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logowanie Spr</title>
    </head>
    <body>
        <%! 
            String name, password; 
            Boolean czyADMIN = false;
        %>
        <% 
            name = request.getParameter("login");
            password = request.getParameter("pass");
            
            out.println("<h1>Proba zalogowania jako: "+name+"</h2>");
            
            out.println("<br><br>");
            if(name.equals("admin") && password.equals("admin")){
                out.println("Jestes teraz ADMINem");
                czyADMIN = true;
            }
            else{
                out.println("Jestes GUESTem");
            }
            
        %>
        
        <%
            if(czyADMIN){
                out.println("<form action=\"admin.jsp\">");
            }
            else{
                out.println("<form action=\"guest.jsp\">");
            }
            
            
        %>
            <input type="submit" value="Dalej">
        </form>
        
        <br><hr>
        <jsp:useBean id="user" class="user.User" scope="session"></jsp:useBean>
        <jsp:setProperty name="user" property="*" />
        Nazwa: <%= user.getUsername() %>
        <br>Albo inaczej<br>
        Nazwa: <jsp:getProperty name="user" property="username" />
        
        <br><hr>
        <form action="index.jsp">
            <input type="submit" value="powrot">
        </form>
    </body>
</html>
