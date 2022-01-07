package control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.*;

@Controller
@RequestMapping(value = "testowy")
public class NewServletTest {
    @RequestMapping("/pierwszy")
    public String pierwszyWidok(Model model) {
        String ciag="Spring MVC";
        model.addAttribute("wiadomosc", ciag);
        return "testing_V";
    }
    
    @RequestMapping("/drugi")
    public String drugiWidok(Model model) throws SQLException {
        Connection db; 
        db = DriverManager.getConnection("jdbc:derby://localhost/lolxd", "root", "root");
        
        db.setAutoCommit(false); 
        Statement st = db.createStatement();
        
        int isNull = 0;
        try{
            ResultSet rs = st.executeQuery("SELECT * FROM ROOT.WASKOL");                 

            while (rs.next()) { 
            	System.out.println(rs.getString(1)+" "+rs.getString(2));
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
        
        return "testing2_V";
    }
}
