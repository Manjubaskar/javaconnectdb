package connectdb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class connectdb {

	  static final String DB_URL = "jdbc:postgresql://localhost:5432/javalearn";
	   static final String USER = "madhu";
	   static final String PASS = "manjubaskar";
	   static final String QUERY = "SELECT * from contacts";
	   
	public static void main(String[] args) {

		      // Open a connection
		      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		         Statement stmt = conn.createStatement();
		    		
		      ) {		      
		          // Execute a query
		          System.out.println("Inserting records into the table...");          
		          String sql = "INSERT INTO contacts (user_name,email,phone) VALUES ('Zara','zara@gamil.com','6384512365')";
		          stmt.executeUpdate(sql);
		          sql = "INSERT INTO contacts (user_name,email,phone) VALUES ('Zavi','zavi@gamil.com','8384512365')";
		          stmt.executeUpdate(sql);
		          
		          System.out.println("Inserted records into the table..."); 
		          ResultSet rs = stmt.executeQuery(QUERY);
		          {		      
		              while(rs.next()){
		                 //Display values
		            	  System.out.print(" user_id: " + rs.getString("user_id"));
		                 System.out.print(", user_name: " + rs.getString("user_name"));
		                 System.out.print(", email: " + rs.getString("email"));
		                 System.out.println(", phone: " + rs.getString("phone"));
		              }
		           } 
		       }  catch (SQLException e) {
		         e.printStackTrace();
		      } 
		   }
		
	}


