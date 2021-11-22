/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BibliotekaPack;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author UL0246827
 */
@WebServlet(name = "LogowanieServ", urlPatterns = {"/LogowanieServ"})
public class LogowanieServ extends HttpServlet {

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
    throws ServletException, IOException, ClassNotFoundException, SQLException {
        //response.setContentType("text/html;charset=UTF-8");
        
        //form
        String INlogin = request.getParameter("login");
        String INpassword = request.getParameter("password");
        
        int isNull = 0;
        
        //DB
        String url = "jdbc:derby://localhost/BibliotekaDB";
        String user = "root"; 
	String passwd = "root"; 
        Connection db = DriverManager.getConnection(url, user, passwd); 
        
        db.setAutoCommit(false); 
        Statement st = db.createStatement();    //utworzenie obiektu typu Statement, który odpowiada za generowanie zapytań do bazy
        
	try{
            ResultSet rs = st.executeQuery("select USERNAME, PASSWORD from USERS "
                    + "where USERNAME = " + INlogin + " AND PASSWORD = " + INpassword);                

            
            while (rs.next()) { 
            //	System.out.println( rs.getString(2)+" "+" "+rs.getString(4) );
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
        
        User Logged = new User();
        
        
        if(isNull == 0){
            request.getRequestDispatcher("/logging_err.jsp").forward(request,response);
        }
        else{
            ResultSet rs = st.executeQuery("select * from USERS "
                    + "where USERNAME = " + INlogin + " AND PASSWORD = " + INpassword);
            
            Logged.setId(rs.getString("ID"));
            Logged.setUsername(rs.getString("USERNAME"));
            Logged.setPassword(rs.getString("PASSWORD"));
            Logged.Name = rs.getString("NAME");
            Logged.Surname = rs.getString("SURNAME");
            
            HttpSession session = request.getSession();
            session.setAttribute("LoggedInUser",Logged);
            request.getRequestDispatcher("/userpage.jsp").forward(request,response);
        }
        
        /*
        try (PrintWriter out = response.getWriter()) {
            // TODO output your page here. You may use following sample code. 
            //out.println("<!DOCTYPE html>");
            //out.println("<html>");
            //out.println("<head>");
            //out.println("<title>Servlet LogowanieServ</title>");            
            //out.println("</head>");
            //out.println("<body>");
            //out.println("<h1>Servlet LogowanieServ at " + request.getContextPath() + "</h1>");
            //out.println("</body>");
            //out.println("</html>");
        }*/
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
    }// </editor-fold>

}
