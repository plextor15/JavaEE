<%@page import="model.Product"%>
<%@ page import = "java.io.*,java.util.*" %>

<html>
   <head>
      <title>Page Redirection</title>
   </head>
   
   <body>
      <center>
         <h1>Page Redirection</h1>
      </center>
      <%
         ArrayList<Product> ListaZakupow = new ArrayList<>();
         session.setAttribute("ListaZakupow", ListaZakupow);
         
         // New location to be redirected
         String site = new String("/Komputery/control/glowna");
         response.setStatus(response.SC_MOVED_TEMPORARILY);
         response.setHeader("Location", site); 
      %>
   </body>
</html>