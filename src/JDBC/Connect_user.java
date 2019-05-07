package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import newspaper1.Aa_add;
import newspaper1.Ab_add;

public class Connect_user {
	Connection conn = null;
	static PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void bbbb(Ab_add bb) {
		try {
			DB_Connect DB=new DB_Connect();
			String sql = "insert into user values(?,?,?,?,?,?,?,?,?)"; 
	    	 pstmt = DB.getCon().prepareStatement(sql);
	    	 pstmt.setString(1, bb.getuName());
			 pstmt.setString(2, bb.getuId());
			 pstmt.setString(3, bb.getuPassword());
			 pstmt.setString(4, bb.getuSex());
			 pstmt.setString(5, bb.getuAddress());
			 pstmt.setString(6, bb.getuTelephone());
			 pstmt.setString(7, bb.getuEmail());
			 pstmt.setInt(8, bb.getuDepartmentID());
			 pstmt.setInt(9, bb.getUsNumber());
			 pstmt.executeUpdate();
		} catch (Exception e) {
		}   
	}
}
