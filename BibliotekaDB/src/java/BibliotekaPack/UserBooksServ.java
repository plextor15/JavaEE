package BibliotekaPack;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.websocket.Session;
/**
 *
 * @author UL0246827
 */
@WebServlet(name = "UserBooksServ", urlPatterns = {"/UserBooksServ"})
public class UserBooksServ extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException, ClassNotFoundException, SQLException  {
        
        //User LoggedIn = (User)session.getAttribute("LoggedInUser");
        User LoggedIn  = new User();
        
        
        String url = "jdbc:derby://localhost/BibliotekaDB";
        String user = "root"; 
	String passwd = "root"; 
        Connection db = DriverManager.getConnection(url, user, passwd); 
        
        db.setAutoCommit(false); 
        Statement st = db.createStatement();
        
	try{
            ResultSet rs = st.executeQuery("select ID, TITLE, LENDTO from BOOKS "
                    + "where LENDTO=" + LoggedIn.Id);                
            
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
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
