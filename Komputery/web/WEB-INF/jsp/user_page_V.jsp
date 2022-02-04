<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
    </head>
    <body>
        <h1>
            <%
                User user_logged = (User)session.getAttribute("user_logged");
                out.println("Witaj " + user_logged.getUsername() + "!");
            %>
        </h1>
        <br>
        <hr>
        <br>
        
    </body>
</html>
