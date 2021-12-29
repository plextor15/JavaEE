<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Testing Page</title>
    </head>
    <body>
        llllllllllhghghgghhghllll<br><hr><br>
        <%
            System.out.println("<h1>Testing</h1>");
            
            int x = (int)session.getAttribute("user_type");
            
            for(int i=0; i < 10; i++){
                out.println(x + "\n");
            }
        %>
    </body>
</html>
