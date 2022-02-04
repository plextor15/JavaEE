package control;

import dao.UserDAO;
import model.User;
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
        //User logged = new User("guest", "guest", 0, 0)
        return "testing_V";
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
        //User userek = (User)session.getAttribute("doZalogowania");
        
        query = "SELECT * FROM USERS WHERE USERNAME='" + userek.getUsername() + "' AND PASSWORD='" + userek.getPassword() + "'";
        
        //Connection db = DriverManager.getConnection("jdbc:derby://localhost/komputery-db", "root", "root");
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
                //DEBUG ONLY!!
//                out.println("Waskol");
//                out.println(rs.getString(2));
//                out.println(rs.getInt(4));
                
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
        //DEBUG ONLY!!
        //out.println(query);
        //out.println(userek.getUsername());
        //out.println(userek.getPassword());
    
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
            }
            redirectURL = "glowna_V";
            //redirectURL = "zly_login_V";
        }
        
        return redirectURL;
    }
        
//    @RequestMapping("/tocheck")   //DEBUG ONLY!!!
//    public String checkPost(Model model, User userek, HttpServletRequest request, HttpServletResponse response) {
//        HttpSession session = request.getSession();
//        
//        session.setAttribute("doZalogowania", userek);
//        
//        return "userDBcheck";
//    }
    
//    @RequestMapping("/dorejestracji")
//    public String doRejestracji(Model model) {
//        return "rejestracja_V";
//    }
  
    @RequestMapping("/rejestracja")
    public String Rejestracja(Model model) {
        return "register_V";
    }
    
        @RequestMapping(value = "/register", method = RequestMethod.GET)
	public String viewStudent(ModelAndView mv) {
            User user = new User();
            mv.addObject("user",user);
            mv.addObject("msg", "?");
            mv.setViewName("register_V");
            //mv.setViewName("testing_V");
                
            return "register_V";                
        }
   
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String createStudent(@RequestParam("id") int id, @RequestParam("username") String username,
	@RequestParam("password") String password, ModelAndView mv) {

            User user = new User();
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
            mv.setViewName("testing_V");
            
            return "register_V";
                
	}
    
    @RequestMapping("/zly_login")
    public String zlyLogin(Model model, User userek, HttpServletRequest request, HttpServletResponse response) {
        return "zly_login_V";
    } 
}
