<%@page import="model.User"%>
<%@page import="control.WazneDane"%>

<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Statement"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sprawdzanie</title>
    </head>
    <body>
        <h1>Sprawdzanie danych logowania...</h1><br>
        
        <%
        
        int type = -50;
        String redirectURL = "zxcv";
        User userek = (User)session.getAttribute("doZalogowania");
        //Connection db = DriverManager.getConnection("jdbc:derby://localhost/komputery-db", "root", "root");
        Connection db = DriverManager.getConnection(WazneDane.getDB(), WazneDane.logDB(), WazneDane.passDB());
        Statement st = db.createStatement();
        
        
        int isNull = 0;
        db.setAutoCommit(false); 
        try{
            ResultSet rs = st.executeQuery("SELECT TYPE FROM USERS WHERE USERNAME='" + userek.getUsername() + "' AND PASSWORD='" + userek.getPassword() + "';");
            while (rs.next()) { 
                type = rs.getInt(4);
                isNull += 1;
            } 
		
            rs.close(); 
            db.commit(); 
            st.close();
            db.close(); 
        }
	catch(SQLException wyjatek) { 
            System.out.println("SQLException: " + wyjatek.getMessage());
            System.out.println("SQLState: " + wyjatek.getSQLState());
            System.out.println("VendorError: " + wyjatek.getErrorCode());
	}
        

        if(type < 0) {
            redirectURL = "zly_login_V.jsp";
        } else {
            if (type == 0){
                session.setAttribute("user_type", 0);
            }
            if (type == 1){
                session.setAttribute("user_type", 1);
            }
            if (type == 2){
                session.setAttribute("user_type", 2);
            }
            redirectURL = "glowna";
        }
        
        response.sendRedirect("/Komputery/control/" + redirectURL);
        %>
        
    </body>
</html>
