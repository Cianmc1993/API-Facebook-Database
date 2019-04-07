public class FacebookDBTester
{
	public static void main(String[] args) 
   {
      FacebookDB fbDb = new FacebookDB();
      fbDb.createDatabase();
      
      String sql =    "INSERT INTO USER(emailaddress, password, firstname, lastname)"+
                      "VALUES('"+email+"', '"+password+"', '"+firstName+"', '"+lastName+"') "+ 
                      "ON DUPLICATE KEY UPDATE " +
                      "password= '"+password+"' , First name= '"+firstName+"', Last name= '"+lastName+"'";
      
      //Inserts string to database
      fbDb.insertIntoDatabase(sql); 
      String password = fbDb.getUserPasswordFromDatabase("cian.mc@lyit.ie");
      System.out.println(password);
        
	}
}