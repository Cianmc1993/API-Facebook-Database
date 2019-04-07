public class FacebookDBTester
{
	public static void main(String[] args) 
   {
      FacebookDB fbDb = new FacebookDB();
      fbDb.createDatabase();
      
      String password = fbDb.getUserPasswordFromDatabase("cian.mc@lyit.ie");
      System.out.println(password);
	}
}