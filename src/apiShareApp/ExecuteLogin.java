package apiShareApp;
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
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;


@Path("/ExecuteLogin") 
@Produces(MediaType.APPLICATION_JSON) 
@Consumes(MediaType.APPLICATION_JSON)     

public class ExecuteLogin {

	 @GET
	 @Path("{name_user}/{password_user}")
	public  Response loginUser(
			@PathParam("name_user")String name_user, 
			@PathParam("password_user")String password_user )  {
		 
	
		 String resultadoConsulta ="";
		 
		 try {
				Class.forName("com.mysql.jdbc.Driver");
				Class.forName("com.mysql.cj.jdbc.Driver");
			} 
		 
		 catch (ClassNotFoundException e) {
			  e.printStackTrace();
			 System.out.println("Error en class for name: " + e.getMessage());
						}  
		
				 try {
				 Connection connection = null;
				 connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/MyAppDatabase","root","armablanca"); 
			 
					 Statement stmt = connection.createStatement();
			 
				 String queryString = "SELECT userId FROM users WHERE " + " name_user= " + "'" + name_user + "'" + " AND password_user = " + "'" + password_user + "'" + " ;";
			 
				 ResultSet rs = stmt.executeQuery(queryString);
				 final StringBuilder builder = new StringBuilder();
				 
				 while( rs.next() ) {
					    builder
					        .append("userId: ").append( rs.getString(1))   ;
					}
					String allResults = builder.toString();
					resultadoConsulta = allResults;
					
			
			 } 
			 catch (SQLException ex) {
			   System.out.println("Error: " + ex.getMessage());
	         
	        	}

				 if (resultadoConsulta.isEmpty()) {
						
					 String error = "error";
					  return Response.ok(error,MediaType.APPLICATION_JSON).build(); 
						
					 
				 }
				 else {
			
					  return Response.ok(resultadoConsulta,MediaType.APPLICATION_JSON).build();   
				 }
				 
	
			
		
		
	}

	
	
	
}
