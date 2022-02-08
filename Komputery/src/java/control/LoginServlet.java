package control;

import dao.UserDAO;
import model.*;
import control.WazneDane;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;

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
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@Controller
@RequestMapping(value = "login")
public class LoginServlet {
    @Autowired
    private UserDAO userDao;

    @RequestMapping("/test")
    public String login(Model model) {
        return "testing_V";
    }
 
    @RequestMapping("/wyloguj")
    public String wyloguj(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = new User("guest", "guest", 0, 0);
        session.setAttribute("user_logged", user);
        session.setAttribute("user_type", 0);

        return "wyloguj_V";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String defaultform(Model model, HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        session.setAttribute("user_type", -50);
        model.addAttribute("login_user", new User("guest", "guest", 0, 0));
        
        return "login_V";
    }

    @RequestMapping("/tocheck")
    public String checkPost(Model model, User userek, HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException, SQLException {
        HttpSession session = request.getSession();
        session.setAttribute("doZalogowania", userek);
        
        int type = -50;
        String redirectURL = "zxcv";
        User user_logged = new User();
        String query;
        
        query = "SELECT * FROM USERS WHERE USERNAME='" + userek.getUsername() + "' AND PASSWORD='" + userek.getPassword() + "'";
        
        Connection db = DriverManager.getConnection(WazneDane.getDB(), WazneDane.logDB(), WazneDane.passDB());
        Statement st = db.createStatement();
        
        int isNull = 0;
        db.setAutoCommit(false);
        try{
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) { 
                type = rs.getInt(4);
                
                user_logged.setUsername(rs.getString(2));
                user_logged.setType(rs.getInt(4));
                               
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
            redirectURL = "zly_login_V";
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

                ArrayList<Product> Lista_Zakupow = new ArrayList<>(); //debug
                session.setAttribute("Lista_Zakupow", Lista_Zakupow); //debug

                ArrayList<Integer> ListaZakupow = new ArrayList<>(); //zeby mogl kupowac
                session.setAttribute("ListaZakupow", ListaZakupow);
            }

            //redirectURL = "glowna_V";
            redirectURL = "redirect_to_glowna";
        }
        
        return redirectURL;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String viewUser(ModelAndView mv) {
        User user = new User();
        mv.addObject("user",user);
        mv.addObject("msg", "?");
        mv.setViewName("register_V");
                
        return "register_V";                
    }
   
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String createUser(@RequestParam("id") int id, @RequestParam("username") String username, @RequestParam("password") String password, ModelAndView mv) 
    throws ServletException, IOException, SQLException {
//        int ostatniID = 4;
//
//        Connection db = DriverManager.getConnection(WazneDane.getDB(), WazneDane.logDB(), WazneDane.passDB());
//        Statement st = db.createStatement(); 
//        String querek = "SELECT * FROM USERS";
//        
//        db.setAutoCommit(false);
//        try{
//            ResultSet rs = st.executeQuery(querek);
//            while (rs.next()) {
//                User tmp = new User();
//                ostatniID = tmp.getId();
//            }
//            ostatniID++;
//		
//            rs.close(); 
//            db.commit(); 
//            st.close();
//            db.close(); 
//        }
//        catch(SQLException wyjatek) { 
//            System.out.println("SQLException: " + wyjatek.getMessage());
//            System.out.println("SQLState: " + wyjatek.getSQLState());
//            System.out.println("VendorError: " + wyjatek.getErrorCode());
//        }

        User user = new User();
//        user.setId(ostatniID);
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setType(2);

        int counter = userDao.create(user);

        if (counter > 0) {
            mv.addObject("msg", "User registration successful");
        } else {
            mv.addObject("msg", "Error");
        }
        //mv.setViewName("register_V");
        //mv.setViewName("testing_V");
        
        return "register_V";            
    }

    @RequestMapping("/zly_login")
    public String zlyLogin(Model model, User userek, HttpServletRequest request, HttpServletResponse response) {
        return "zly_login_V";
    }
}