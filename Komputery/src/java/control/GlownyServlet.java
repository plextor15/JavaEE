package control;

import model.*;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value = "glowna")
//@WebServlet(name = "GlownyServlet", urlPatterns = {"/GlownyServlet"})
public class GlownyServlet extends HttpServlet {

    @RequestMapping("/test")
    public String testingOnly() {
        return "testing_V";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String glowna() {
        return "glowna_V";
    }


    @RequestMapping("/userpage")
    public String userPage(Model model, User userek, HttpServletRequest request, HttpServletResponse response) {
        String urladdress = "xzy";
        
        HttpSession session = request.getSession();
        User userek = (User)session.getAttribute("user_logged");
        
        return "user_page_V";
        //return "testing_V";
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
