package users;

import com.sun.org.apache.xml.internal.serializer.utils.StringToIntTable;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
        
@WebServlet(name = "Logowanie_Servlet", urlPatterns = {"/Logowanie_Servlet"})

public class Logowanie_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {        

        String login = request.getParameter("newLogin");
        String password = request.getParameter("newPass");
        
        String czyAdmin;
        if(login.equals("admin") && password.equals("admin")){
            czyAdmin = "Zalogowano";
        }else{
            czyAdmin = "Nie zalogowano";
        }
        
        HttpSession session = request.getSession();
        session.setAttribute("daneZSerwletu",czyAdmin);
        
        //request.getRequestDispatcher("/newformularz_wynik.jsp").forward(request,response); 
    }
}