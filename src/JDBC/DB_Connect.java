package JDBC;
import java.sql.*;

public class DB_Connect {

	String DBDRIVER = "com.mysql.cj.jdbc.Driver";
	String DBURL = "jdbc:mysql://localhost:3306/newspaper?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false&allowPublicKeyRetrieval=true";
	String DBUSER = "root";
	String DBPASS = "6198611nao";

	public Connection getCon() throws Exception {
		Class.forName(DBDRIVER);
		Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		return con;
	}
	
	public static void main(String[] args) {
		DB_Connect DBC = new DB_Connect();
		try {
			Connection dbc = DBC.getCon();
			if(dbc!=null) {
				System.out.println("数据库连接成功！");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
