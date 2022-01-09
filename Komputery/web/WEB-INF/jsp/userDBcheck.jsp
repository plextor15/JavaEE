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
        User user_logged = new User();
        String query;
        
        query = "SELECT * FROM USERS WHERE USERNAME='" + userek.getUsername() + "' AND PASSWORD='" + userek.getPassword() + "'";
        
        
        //Connection db = DriverManager.getConnection("jdbc:derby://localhost/komputery-db", "root", "root");
        Connection db = DriverManager.getConnection(WazneDane.getDB(), WazneDane.logDB(), WazneDane.passDB());
        Statement st = db.createStatement();
        
        out.println("Waskol");
        
        int isNull = 0;
        db.setAutoCommit(false); 
        //try{
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) { 
                type = rs.getInt(4);
                
                user_logged.setUsername(rs.getString(2));
                user_logged.setType(rs.getInt(4));
                
                //DEBUG ONLY!!
                out.println("Waskol");
                out.println(rs.getString(2));
                out.println(rs.getInt(4));
                
                isNull += 1;
            } 
		
            rs.close(); 
            db.commit(); 
            st.close();
            db.close(); 
//        }
//	catch(SQLException wyjatek) { 
//            System.out.println("SQLException: " + wyjatek.getMessage());
//            System.out.println("SQLState: " + wyjatek.getSQLState());
//            System.out.println("VendorError: " + wyjatek.getErrorCode());
//	}
        
        //DEBUG ONLY!!
        out.println(query);
        //out.println(userek.getUsername());
        //out.println(userek.getPassword());

        
        
        if(type < 0) {
            redirectURL = "login/zly_login";
        } else {
            session.setAttribute("user_logged", user_logged);
            
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
