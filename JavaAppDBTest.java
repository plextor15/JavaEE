package javaappdbtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class JavaAppDBTest {

    public static void main(String[] args) throws SQLException {
        System.out.println("\n\nWaskolwiek ist that\n\n");
        
        
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
    }   
}
