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
import javax.ws.rs.Path; 
import javax.ws.rs.Produces; 
import javax.ws.rs.core.MediaType; 
import javax.ws.rs.core.Response; 
import java.sql.CallableStatement;  


@Path("/ExecuteInsertUser") 

public class ExecuteInsertUser {

	 @POST
	public  void insertUser()  {
		
		 try {
			 Connection connection = null;
			 connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/MyAppDatabase","root","armablanca");
			 
			 
			 CallableStatement cStmt = connection.prepareCall("{call insert_user_procedure(?,?)}"); 
			 cStmt.setString( "name_user", "victor333333");  
			 cStmt.setString("password_user", "ilerna");  
			 
			 cStmt.execute();   
		
		   
		
		 } 
		 catch (SQLException ex) {
	            System.out.println("Error: " + ex.getMessage());
	         
	}
		
		
		
		
		
	}
	
	
	
	

	
	
	
	
}
