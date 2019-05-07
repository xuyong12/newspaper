package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conn {
	public static final String url="jdbc:mysql://localhost:3306/newspaper?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false&allowPublicKeyRetrieval=true";
	public static final String useName="root";
	public static final String password="6198611nao";
	static Connection connection=null;
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			 connection=DriverManager.getConnection(url,"root","6198611nao");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return connection;		
	}
	public static void close(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}