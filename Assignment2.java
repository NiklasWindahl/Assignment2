//import java.sql.Connection;
import java.sql.*;

public class Assignment2{
public static Connection getConnection() throws Exception {
  try{
    //ändra url
    String url = "jdbc:mysql://localhost:3306/jdbc_demo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String username = "user";
    String password = "password";

    Connection conn = DriverManager.getConnection(url,username,password);
    System.out.println("Connected to database!");
    return conn;
  } catch (Exception e){System.out.println(e);}
  return null;
 }

 public static void main(String[] args) throws Exception  {
    Connection conn = getConnection();
    Statement statement = conn.createStatement();
    ResultSet res = statement.executeQuery("Select * from cars");

    while (res.next()) {
      System.out.println(res.getString("car_id")+": "+
                         res.getString("brand")+
                         res.getString("color"));

    }

 }
}
