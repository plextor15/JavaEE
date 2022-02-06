<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.*"%>
<%@page import="java.io.PrintWriter"%>

<%@page import="model.*"%>
<%@page import="control.WazneDane"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Komputerowy SHOP</title>
    </head>
    <style>
        .rec01{
            position: absolute;
            width: 799px;
            height: 145px;
            background-image: linear-gradient(to right, #1f1f1f, #004466);
            border: 7px solid #00FF19;
            box-sizing: border-box;
        }
        h2 {
            position: absolute;
            width: 800px;
            height: 80px;
            font-family: Courier, Monospace;
            font-size: 80px;
            line-height: 20px;
            display: flex;
            align-items: center;
            text-align: center;
            color: #DDDDDD;
            /*text-stroke: 4px solid #00A0E4;*/
        }
        #tekst {
            position: fixed;
            bottom: 400px;
            right: 400px;
            
            text-indent: 150px;
            text-align: justify;
            letter-spacing: 7px;
            color: white;
        }
        #grad01 {
            background-color: #404040; /*jakby nie zadzialalo to staly kolor*/
            background-image: linear-gradient(to bottom right, #2e2e2e 65%, #737373 125%);
            background-repeat: no-repeat;
            background-attachment: fixed;
        }
        #product {
            background-color: #404040; /*jakby nie zadzialalo to staly kolor*/
            background: linear-gradient(to right, #222222 56%, #dddddd 125%);
            color: #DDDDDD;
            border: 4px solid #000000;
        }
        #kup {
            
        }
        #niekup {
            
        }
        .tab {
            display: inline-block;
            margin-left: 50px;
        }
        
        
    </style>
    <body id="grad01">
        <div class="rec01">
            <h2>KOMPUTEROWY SHOP</h2>
        </div>
        <div><%
            PrintWriter pw = response.getWriter();
            User userek = (User)session.getAttribute("user_logged");
            int user_type = (int)session.getAttribute("user_type");
        
            pw.print("Zalogowano jako: ");
        
            if(user_type != 0){
                pw.print("<a href=\"/Komputery/control/glowna/userpage\">");
                pw.print(userek.getUsername());
                pw.print("</a>");
            } else {
                pw.print(userek.getUsername()); //guest
            }
        %></div>
        
        <%
            
            ArrayList<Product> ListaProd = new ArrayList<>();
            ListaProd = (ArrayList<Product>)session.getAttribute("ListaProd");
            Product product = new Product();
            String typ = "RODZAJ";
            int xtyp = 0;
            
            for (int i = 0; i < ListaProd.size(); i++) {
                product = ListaProd.get(i);
            //for (Product product : ListaProd) {
                xtyp = product.getType();
                if(xtyp == 0) {typ = "Inne";}
                if(xtyp == 1) {typ = "Procesor";}
                if(xtyp == 2) {typ = "RAM";}
                if(xtyp == 3) {typ = "Karta graficzna";}
                if(xtyp == 4) {typ = "Nośnik danych";}
                    
                pw.println("<div id=\"product\">");
                pw.print("<h1>");
                pw.print("<b>");
                pw.print(product.getName());
                pw.print("</b>");
                pw.print("<span class=\"tab\"></span>");
                pw.print(product.getPrice() + " zł");
                pw.print("<span class=\"tab\"></span>");
                pw.print("<span class=\"tab\"></span>");
                
                if(user_type == 2 && product.getAmount() > 0) {
                    pw.print("<a href=\"/Komputery/control/glowna/kupno?id=" + product.getId() + "\">KUP</a>");
                }
                pw.print("</h1>");

                
                if (product.getAmount() == 0) {
                    pw.print("<h5 style=\"color:red\">");
                    pw.print("Niedostępne");
                    pw.print("</h5>");
                } else {
                    pw.print("<h5>");
                    pw.print(product.getAmount() + " szt.");
                    pw.print("</h5>");
                }
                pw.print("<span class=\"tab\"></span>");
                pw.print("<h5>");
                pw.print(typ);
                pw.print("</h5>");
                
                pw.println("</div>");
                pw.println("<br>");
            }
            
        %>
        
        <%
            /*
            Connection db = DriverManager.getConnection(WazneDane.getDB(), WazneDane.logDB(), WazneDane.passDB());
            Statement st = db.createStatement();
            
            String queryAll = "SELECT * FROM PRODUCTS";
            String querek = queryAll;   //do wykonania
            
            String nazwa = "NAZWA", typ = "RODZAJ";
            double cena;
            int ilosc, xtyp;
            
            db.setAutoCommit(false);
            try{
                ResultSet rs = st.executeQuery(querek);
                while (rs.next()) {
                    nazwa = rs.getString(2);
                    cena = rs.getDouble(3);
                    ilosc = rs.getInt(4);
                    xtyp = rs.getInt(5);
                    if(xtyp == 0) {typ = "Inne";}
                    if(xtyp == 1) {typ = "Procesor";}
                    if(xtyp == 2) {typ = "RAM";}
                    if(xtyp == 3) {typ = "Karta graficzna";}
                    if(xtyp == 4) {typ = "Nośnik danych";}
                    
                    
                    pw.println("<div id=\"product\">");
                    pw.print("<h1>");
                        pw.print("<b>");
                        pw.print(nazwa);
                        pw.print("</b>");
                    //pw.print("<h2>");
                        pw.print("<span class=\"tab\"></span>");
                        pw.print(cena + " zł");
                    pw.print("</h1>");
                    
                    //pw.println("<br>");
                        pw.print(typ);
                        pw.print("<span class=\"tab\"></span>");
                        if (ilosc == 0) {
                            pw.print("<h5 style=\"color:red\">");
                            pw.print("Niedostępne");
                            pw.print("</h5>");
                        }
                        else {
                            pw.print("<h5>");
                            pw.print(ilosc + " szt.");
                            pw.print("</h5>");
                        }
                    
                    if(user_type == 1){
                        
                    }
                    
                    pw.println("</div>");
                    pw.println("<br>");
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
           */ 
        %>
    </body>
</html>
