package apiz;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.Entity;
import javax.ws.rs.Consumes; 
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path; 
import javax.ws.rs.Produces; 
import javax.ws.rs.core.MediaType; 
import javax.ws.rs.core.Response; 
import java.sql.CallableStatement;  


@Path("/ExecuteInsertUser") 

public class ExecuteInsertUser {

	 @GET
	public  void insertUser()  {
		 
		 try {
			    //Class.forName("com.mysql.jdbc.Driver");
				Class.forName("com.mysql.cj.jdbc.Driver");
			} 
			catch (ClassNotFoundException e) {
			    // TODO Auto-generated catch block
			    e.printStackTrace();
			    System.out.println("Error en class for name: " + e.getMessage());
			} 
		 
		 
		
		 try {
			 Connection connection = null;
			 connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/MyAppDatabase","root","armablanca");
			 
			 
			 CallableStatement cStmt = connection.prepareCall("{call insert_user_procedure(?,?)}"); 
			 cStmt.setString(1, "victor333333");  
			 cStmt.setString(2, "ilerna");  
			 
			 cStmt.execute();   
		
		   
		
		 } 
		 catch (SQLException ex) {
	            System.out.println("Error: " + ex.getMessage());
	         
	}
		
		
		
		
		
	}
	
	
	
	

	
	
	
	
}
