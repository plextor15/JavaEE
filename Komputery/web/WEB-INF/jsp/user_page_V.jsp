<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.*"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="model.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
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
            Koszyk:<br>
        <%
            PrintWriter pw = response.getWriter();
            ArrayList<Product> Koszyk = new ArrayList<>();
            Koszyk = (ArrayList<Product>)session.getAttribute("Koszyk");
            Product product = new Product();
            String typ = "RODZAJ";
            int xtyp = 0;
            
            for (int i = 0; i < Koszyk.size(); i++) {
                product = Koszyk.get(i);
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
                
                /*if(user_type == 2 && product.getAmount() > 0) {
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
                pw.print("</h5>");*/
                
                pw.println("</div>");
                pw.println("<br>");
            }

            
        %>
        <a href="/Komputery/control/glowna">Powrót</a><br>
        <a href="/Komputrey/control/login">Wyloguj</a>
    </body>
</html>
