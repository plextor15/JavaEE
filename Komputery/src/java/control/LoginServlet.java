package control;

import model.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping("/test")
    public String login(Model model) {
        //User logged = new User("guest", "guest", 0, 0)
        return "testing_V";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String defaultform(Model model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        session.setAttribute("user_type", -50);
        model.addAttribute("login_user", new User("guest", "guest", 0, 0));
        
        return "login_V";
    }
    
    @RequestMapping("/tocheck")
    public String checkPost(Model model, User userek, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        
        session.setAttribute("doZalogowania", userek);
        
        return "userDBcheck";
    } 
}
