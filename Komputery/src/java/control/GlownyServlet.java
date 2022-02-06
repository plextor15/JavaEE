package control;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import model.*;
import control.WazneDane;

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

        Connection db = DriverManager.getConnection(WazneDane.getDB(), WazneDane.logDB(), WazneDane.passDB());
        Statement st = db.createStatement();
            
        String queryAll = "UPDATE PRODUCTS SET AMOUNT=AMOUNT-1 WHERE ID=" + idek + "; SELECT * FROM PRODUCTS WHERE ID=" + idek + ";";
        String querek = "SELECT * FROM PRODUCTS WHERE ID=" + idek;
        String queryIlosc = "UPDATE PRODUCTS SET AMOUNT=AMOUNT-1 WHERE ID=" + idek;

        ArrayList<Product> ListaZakupow = new ArrayList<>();
        ListaZakupow =  (ArrayList<Product>)session.getAttribute("ListaZakupow");   

        //do koszyka klienta
        db.setAutoCommit(true);
        try{
//            ResultSet rs = st.executeQuery(querek);
//            while (rs.next()) {
//                Product tmp = new Product();
//                tmp.setId(rs.getInt(1));
//                tmp.setName(rs.getString(2));
//                tmp.setPrice(rs.getDouble(3));
//                tmp.setAmount(rs.getInt(4));
//                tmp.setType(rs.getInt(5));
//                ListaZakupow.add(tmp);
//            } 
//            rs.close(); 

            ResultSet rs2 = st.executeQuery(queryIlosc);		
            while (rs2.next()) {}
            rs2.close();
            
            db.commit(); 
            st.close();
            db.close(); 
        }
        catch(SQLException wyjatek) { 
            System.out.println("SQLException: " + wyjatek.getMessage());
            System.out.println("SQLState: " + wyjatek.getSQLState());
            System.out.println("VendorError: " + wyjatek.getErrorCode());
        }

        session.setAttribute("ListaZakupow", ListaZakupow);

        //ilosc - 1
        /*
        db.setAutoCommit(true);
        try{
            ResultSet rs = st.executeQuery(queryIlosc);
            
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
        
        return "glowna_V";
        //return "redirect_to_glowna";
    }


    @RequestMapping(method = RequestMethod.GET)
    public String glowna(Model model, User userek, HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException, SQLException{
        HttpSession session = request.getSession();

        Connection db = DriverManager.getConnection(WazneDane.getDB(), WazneDane.logDB(), WazneDane.passDB());
        Statement st = db.createStatement();
            
        String queryAll = "SELECT * FROM PRODUCTS";
        String querek = queryAll;   //do wykonania
        
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
    public String userPage(Model model, User userek, HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException, SQLException{
        String urladdress = "xzy";
        
        HttpSession session = request.getSession();
        //userek = (User)session.getAttribute("user_logged");
        
/*
        Connection db = DriverManager.getConnection(WazneDane.getDB(), WazneDane.logDB(), WazneDane.passDB());
        Statement st = db.createStatement();
            
        String queryAll = "SELECT * FROM PRODUCTS";
        String querek = queryAll;   //do wykonania
        
        ArrayList<Product> ListaProd = new ArrayList<>();
        Product tmp = new Product();
    
        db.setAutoCommit(false);
        try{
            ResultSet rs = st.executeQuery(querek);
            while (rs.next()) {
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
*/
        return "user_page_V";
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
