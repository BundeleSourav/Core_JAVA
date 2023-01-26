package day20;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;

public class IOUtils {
	public static Connection con;
	
	public static Connection getconnectionto() throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Loaded!!!");
		
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dac22","root","sourav@88");
		System.out.println("Entered.....");
	
		return con;
	}
}
