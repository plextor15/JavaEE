package control;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import model.*;
import control.WazneDane;

import java.io.*;
import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = "glowna")
//@WebServlet(name = "GlownyServlet", urlPatterns = {"/GlownyServlet"})
public class GlownyServlet extends HttpServlet {

    @RequestMapping("/test")
    public String testingOnly() {
        return "testing_V";
    }
    
    @RequestMapping(value = "/kupno", method = RequestMethod.GET)
    public String glownaKupno(Model model, @RequestParam(value="id") String idek, User userek, HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, SQLException{
        HttpSession session = request.getSession();

        ArrayList<Product> Lista_Zakupow = new ArrayList<>();
        Lista_Zakupow = (ArrayList<Product>)session.getAttribute("Lista_Zakupow");

        Connection db = DriverManager.getConnection(WazneDane.getDB(), WazneDane.logDB(), WazneDane.passDB());
        Statement st = db.createStatement();
            
        String querek = "SELECT * FROM PRODUCTS WHERE ID=" + idek;
        String queryIlosc = "UPDATE PRODUCTS SET AMOUNT=AMOUNT-1 WHERE ID=" + idek;
 

        //do koszyka klienta
        db.setAutoCommit(true);
        try{
            ResultSet rs = st.executeQuery(querek);
            while (rs.next()) {
                Product tmp = new Product();
                tmp.setId(rs.getInt(1));
                tmp.setName(rs.getString(2));
                tmp.setPrice(rs.getDouble(3));
                tmp.setAmount(rs.getInt(4));
                tmp.setType(rs.getInt(5));
                Lista_Zakupow.add(tmp);
            } 
            rs.close(); 

            st.executeUpdate(queryIlosc);
            
            db.commit(); 
            st.close();
            db.close(); 
        }
        catch(SQLException wyjatek) { 
            System.out.println("SQLException: " + wyjatek.getMessage());
            System.out.println("SQLState: " + wyjatek.getSQLState());
            System.out.println("VendorError: " + wyjatek.getErrorCode());
        }

        ArrayList<Integer> ListaZakupow = new ArrayList<>();
        ListaZakupow =  (ArrayList<Integer>)session.getAttribute("ListaZakupow");
        ListaZakupow.add(Integer.valueOf(idek));
        session.setAttribute("ListaZakupow", ListaZakupow);

        session.setAttribute("Lista_Zakupow", Lista_Zakupow);
        //return "glowna_V";
        return "redirect_to_glowna"; //zeby strona sie odswiezyla
    }

    @RequestMapping(value = "/rezygnuj", method = RequestMethod.GET)
    public String rezygnacjaKupna(Model model, @RequestParam(value="id") String ktory, HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, SQLException{
        HttpSession session = request.getSession();
        int ktoryNaLiscie = Integer.valueOf(ktory); 
        Product tmp;

        ArrayList<Product> Lista_Zakupow = new ArrayList<>();
        Lista_Zakupow = (ArrayList<Product>)session.getAttribute("Lista_Zakupow");

        Connection db = DriverManager.getConnection(WazneDane.getDB(), WazneDane.logDB(), WazneDane.passDB());
        Statement st = db.createStatement();
        
        tmp = Lista_Zakupow.get(ktoryNaLiscie);
        String queryIlosc = "UPDATE PRODUCTS SET AMOUNT=AMOUNT+1 WHERE ID=" + tmp.getId();

        db.setAutoCommit(true);
        try{
            st.executeUpdate(queryIlosc);
            
            db.commit(); 
            st.close();
            db.close(); 
        }
        catch(SQLException wyjatek) { 
            System.out.println("SQLException: " + wyjatek.getMessage());
            System.out.println("SQLState: " + wyjatek.getSQLState());
            System.out.println("VendorError: " + wyjatek.getErrorCode());
        }

        Lista_Zakupow.remove(ktoryNaLiscie); //usuniecie z listy zakupow

        session.setAttribute("Lista_Zakupow", Lista_Zakupow);
        return "redirect_to_userpage"; //zeby strona sie odswiezyla
    }

    @RequestMapping(method = RequestMethod.GET)
    public String glowna(Model model, User userek, HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException, SQLException{
        HttpSession session = request.getSession();

        Connection db = DriverManager.getConnection(WazneDane.getDB(), WazneDane.logDB(), WazneDane.passDB());
        Statement st = db.createStatement();
            
        String querek = "SELECT * FROM PRODUCTS";
        ArrayList<Product> ListaProd = new ArrayList<>();
        
    
        db.setAutoCommit(false);
        try{
            ResultSet rs = st.executeQuery(querek);
            while (rs.next()) {
                Product tmp = new Product();
                tmp.setId(rs.getInt(1));
                tmp.setName(rs.getString(2));
                tmp.setPrice(rs.getDouble(3));
                tmp.setAmount(rs.getInt(4));
                tmp.setType(rs.getInt(5));
                ListaProd.add(tmp);
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

        session.setAttribute("ListaProd", ListaProd);
        return "glowna_V";
    }

    @RequestMapping("/userpage")
    public String userPage(Model model, User userek, HttpServletRequest request, HttpServletResponse response){
        return "user_page_V";
    }

    @RequestMapping("/adminpage")
    public String guestPage(Model model, User userek, HttpServletRequest request, HttpServletResponse response){
        return "admin_page_V";
    }

    @RequestMapping("/guestpage")
    public String guestPage(Model model, HttpServletRequest request, HttpServletResponse response){
        return "guest_page_V";
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
