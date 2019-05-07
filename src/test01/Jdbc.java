package test01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Jdbc {
	Connection conn=null;
	Statement stmt = null;
	ResultSet rs = null;
	
	String driver="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/newspaper?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false&allowPublicKeyRetrieval=true";
	String name="root";
	String password="6198611nao";
}
