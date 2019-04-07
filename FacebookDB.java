/**
* Class: B.Sc. in Computing
* Description: A JDBCFacebookDB class - Contains methods to work with the Facebook database
* Date: 12/03/2019
* @author Maria Boyle
* @version 1.0
*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class FacebookDB implements DBOperations
{
   // JDBC database URL, user name and password
	private final String DB_URL = "jdbc:mysql://localhost/";
	private final String USER_NAME = "root";
	private final String PASSWORD = "password";
   
   private Connection conn;
   
   // Constructor
   public FacebookDB(){
      conn=null;
   }

   // createConnection() - Opens a connection to DB_URL
   public void createConnection(String dbUrl){
		try{
			// STEP 1 - Open a connection
			//          Use the DriverManager.getConnection() method to create a Connection object,
			//          which represents a physical connection with the database server.
		   conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
		   System.out.println("COMPLETE - Connection obtained...");
      }
		catch (SQLException e) {
			System.out.println("Cannot create connection.\n" + e.getMessage());
		}
   }
   
   // createDatabase() - Calls createConnection(), creates a database called facebook with a table called user
   public void createDatabase(){
		try{
         // createConnection() to localhost
         createConnection(DB_URL);

 	      // Create Statement object		    
  	      Statement stmt = conn.createStatement();
 	      System.out.println("COMPLETE - Statement object created...");
          
	      // Execute Update to Create a Database called facebook
		   String createDatabase = "CREATE DATABASE IF NOT EXISTS facebook"; 
		   stmt.executeUpdate(createDatabase);
		   System.out.println("COMPLETE - Update executed and facebook database created...");
          
		   // Execute Update to Create a Table called user
		   String createTable = "CREATE TABLE IF NOT EXISTS user " +
	                            "(emailaddress VARCHAR(24) not NULL, " +
	                            " password VARCHAR(18), " + 
	                            " firstname VARCHAR(20), " + 
	                            " lastname VARCHAR(20), " + 
	                            " PRIMARY KEY (emailaddress))"; 

		   stmt.executeUpdate("USE facebook");
		   stmt.executeUpdate(createTable);
		   System.out.println("COMPLETE - Update executed and user table added to facebook database...");
         
         // closeConnection()
         closeConnection();
      }
		catch (SQLException e){
			System.out.println("Problem with SQL.\n" + e.getMessage());
		}
   }

   // closeConnection() - Closes the connection
   public void closeConnection(){   
			try{
				if(conn != null){
               conn.close();
			      System.out.println("COMPLETE - Connection closed.");				
            }
			}
			catch (SQLException e){
				System.out.println("Could not close connection.\n" + e.getMessage());
			}
   }
   //Part 2
   public void insertIntoDatabase(String sqlString)
   {
		createConnection(DB_URL);  
		try{ 
   	   Statement statement = conn.createStatement(); //Creates statement object
   		System.out.println("Object has successfully been created");
			try{
            statement.executeUpdate("USE facebook"); //User the facebook database
            statement.executeUpdate(sqlString); //Executes the sql query in the database
            System.out.println("Statement executed successfully");
			}
			catch(SQLException e){
				System.out.println("Problem with SQL.\n" + e.getMessage());
			}
		}
		catch(SQLException e){
			System.out.println("Problem with SQL.\n" + e.getMessage());
		}
		closeConnection();  // Closes connection
	}   
   //Part 4
   public String getUserPasswordFromDatabase(String emailAddress)
   {
      String sql = "SELECT * FROM user WHERE emailaddress = '"+emailAddress+"'"; //Sql query to be executed in database
      String password = "";
      ResultSet result = null;
          
	   createConnection(DB_URL);
      try{
   	   Statement statement = conn.createStatement(); //Creates statement object
   		System.out.println("Object has successfully been created");
   		try{
            statement.executeUpdate("USE facebook"); //User the facebook database
            result = statement.executeQuery(sql); //Executes the sql query in the database
            System.out.println("Statement executed successfully");
         }
         catch(SQLException e){
   				System.out.println("Problem with SQL.\n" + e.getMessage());   
   		}
   	}
   	catch(SQLException e){
   			System.out.println("Problem with SQL.\n" + e.getMessage());
   		}
      
      try{
			while(result.next()){
				password = result.getString("password");
			}
		}
   		catch(SQLException e){
   			System.out.println("Problem with SQL.\n" + e.getMessage());
   		}
     		
   		closeConnection(); //Closes connection 
   		return password; //returns password
   }

}