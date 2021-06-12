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
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces; 
import javax.ws.rs.core.MediaType; 
import javax.ws.rs.core.Response; 
import java.sql.CallableStatement;  


@Path("/ExecuteInsertUser") 
@Produces(MediaType.APPLICATION_JSON) 
@Consumes(MediaType.APPLICATION_JSON)    

public class ExecuteInsertUser {
	


	 @GET
	 @Path("{name_user}/{password_user}")
	public  Response insertUser(
			@PathParam("name_user")String name_user, 
			@PathParam("password_user")String password_user ) {  
		 
		
		 String resultadoInsert="";

		 try {
			  
				Class.forName("com.mysql.cj.jdbc.Driver");
			} 
			catch (ClassNotFoundException e) {
			    e.printStackTrace();
			    System.out.println("Error en class for name: " + e.getMessage());
			} 
		 
		 
		
		 try {
			 Connection connection = null;
			 connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/MyAppDatabase","root","armablanca");
			 
			 
			 CallableStatement cStmt = connection.prepareCall("{call insert_user_procedure_andList(?,?)}"); 
			 cStmt.setString(1, name_user);  
			 cStmt.setString(2, password_user);  
			 
			 cStmt.execute();   
			 
		   
		
		 } 
		 catch (SQLException ex) {
	            System.out.println("Error: " + ex.getMessage());
	            resultadoInsert= "error";
	         
	}
		
		
		if (resultadoInsert != "error") {
			
		//	return  createUserList(name_user);
			 return Response.ok("ok",MediaType.APPLICATION_JSON).build();  
			
			  
			
		}
		else {
			 return Response.ok("error",MediaType.APPLICATION_JSON).build();   
		}
	
		

		
	}
	
	/* public Response createUserList (String name_user) {
		
		 try {
			 Connection connection = null;
			 connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/MyAppDatabase","root","armablanca");
			 
			 
			 CallableStatement cStmt = connection.prepareCall("{call insertar_list(?)}"); 
			 cStmt.setString("name_user", name_user);
			 cStmt.execute();   
			 
		   
		
		 } 
		 catch (SQLException ex) {
	            System.out.println("Error: " + ex.getMessage());
	        
	       	 return Response.ok("error Insert UserList",MediaType.APPLICATION_JSON).build();   
	}
		 return Response.ok("ok",MediaType.APPLICATION_JSON).build();   
		
	}
	*/
	

	
	
	
	
}
