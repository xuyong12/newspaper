package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import newspaper1.Ab_add;
import newspaper1.Ac_add;

public class Connect_department {
	Connection conn = null;
	static PreparedStatement pstmt = null;
	ResultSet rs = null;
	public void cccc(Ac_add cc) {
		try {
			DB_Connect DB=new DB_Connect();
			String sql = "insert into department values(?,?)"; 
	    	 pstmt = DB.getCon().prepareStatement(sql);
	    	 pstmt.setInt(1, cc.getdID());
			 pstmt.setString(2, cc.getdName());
			 pstmt.executeUpdate();
		} catch (Exception e) {
		}   
	}
}
