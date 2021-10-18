package testowy_pack;

import com.sun.org.apache.xml.internal.serializer.utils.StringToIntTable;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
        
@WebServlet(name = "Servlecik", urlPatterns = {"/Servlecik"})

public class Servlecik extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {        
//        String dane=request.getParameter("daneZFormularza");
//        String ileStr = request.getParameter("ile");
//        
//        String daneWynikowe=dane+" - "+dane;
//        
//        HttpSession session = request.getSession();
//        session.setAttribute("daneZSerwletu",daneWynikowe);

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
        
        request.getRequestDispatcher("/newformularz_wynik.jsp").forward(request,response); 
    }
}