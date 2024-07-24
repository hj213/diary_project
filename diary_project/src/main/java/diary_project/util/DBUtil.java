package diary_project.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
public static Connection conn;
	
	public static Connection getConnection(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/diary_db?useSSL=false&serverTimezone=UTC","root","Yun422537265!");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void closeConnection(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
