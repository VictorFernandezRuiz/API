package apiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.ws.rs.Consumes; 
import javax.ws.rs.GET; 
import javax.ws.rs.Path; 
import javax.ws.rs.Produces; 
import javax.ws.rs.core.MediaType; 
import javax.ws.rs.core.Response; 

@Path("/TestConnectionBBDD") 
@Produces(MediaType.APPLICATION_JSON) 
@Consumes(MediaType.APPLICATION_JSON)     
	
	
public class TestConnectionBBDD {
	
	@GET
	public Response testConnection() {
		
		 
		 try {
			 Connection connection = null;
			 connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/MyAppDatabase","root","armablanca");
		
		    return Response.ok("CONNECTION OK",MediaType.APPLICATION_JSON).build();   
		 } 
		 catch (SQLException ex) {
	            System.out.println("Error: " + ex.getMessage());
	            return Response.ok("ERROR",MediaType.APPLICATION_JSON).build();
	}
		    
		
	}
}
	

	   
	



