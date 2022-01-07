package control;

import model.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.tomcat.jni.SSLContext;
import org.springframework.test.web.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import org.springframework.test.web.servlet.request.*;

import com.sun.org.apache.xml.internal.serializer.utils.StringToIntTable;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@Controller
@RequestMapping(value = "login")
public class LoginServlet {
//    @RequestMapping("/login")
//    public String login(Model model) {
//        return "login_V";
//    }
    @RequestMapping("/test")
    public String login(Model model) {
        //User logged = new User("guest", "guest", 0, 0)
        
        return "testing_V";
    }
    
    
    @RequestMapping(method = RequestMethod.GET)
    public String defaultform(Model model,       HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //HttpSession session = request.getSession();
        HttpSession session = request.getSession();
        session.setAttribute("user_type", -1);
        
        
        model.addAttribute("login_user", new User("guest", "guest", 0, 0));
        return "login_V";
    }
    
    @RequestMapping("/check")
    //@RequestMapping(method = RequestMethod.POST)
    public String checkPost(User userek,    HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int jakoKto = 50;
        String lolxd = "qwerty";
        //System.out.println("DEBUG");//DEBUG ONLY!!!!
        Connection db; 
        db = DriverManager.getConnection("jdbc:derby://localhost/komputery-db", "root", "root");
        
        db.setAutoCommit(false); 
        Statement st = db.createStatement();
        //System.out.println("DEBUG");//DEBUG ONLY!!!!
        int isNull = 0;
        try{
            //ResultSet rs = st.executeQuery("SELECT TYPE FROM USERS WHERE USERNAME='" + userek.getUsername() + "' AND PASSWORD='" + userek.getPassword() + "';");
            ResultSet rs = st.executeQuery("SELECT * FROM ROOT.USERS FETCH FIRST 10 ROWS ONLY;");

            while (rs.next()) { 
            	//System.out.println(rs.getString(1)+" "+rs.getString(2));
                //isNull += 1;
                lolxd = rs.getString(2);
                jakoKto = rs.getInt(1);
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
        
        //Logika
        HttpSession session = request.getSession();
        //int x = ;
        
        //if((int)session.getAttribute("user_type") == -1) return "testing_V"; //DEBUG ONLY!!!
        
//        if (isNull != 0){
//            if(jakoKto == 0) {//jako guest
//                session.setAttribute("user_type", 0);
//            }
//            if(jakoKto == 1) { //jako admin
//                session.setAttribute("user_type", 1);
//            }
//            if(jakoKto == 2) { //jako zarejestrowany
//                session.setAttribute("user_type", 2);
//            }
//            
//            return "glowna_V";
//        }
        session.setAttribute("ktoryZKolei", lolxd);
        session.setAttribute("user_type", jakoKto);
        return "zly_login_V"; //zle logowanie
    }
}
