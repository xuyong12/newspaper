package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import newspaper1.Aa_add;

public class Connect_newspaper {
	Connection conn = null;
	static PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void aaaa(Aa_add aa) {
		try {
			DB_Connect DB=new DB_Connect();
			String sql = "insert into magazine values(?, ?, ?, ?, ?)";
			System.out.println("jdjidji");
			System.out.println("这是邦本1.1");
	    	 pstmt = DB.getCon().prepareStatement(sql);
	    	 pstmt.setInt(1, aa.getmID());
			 pstmt.setString(2, aa.getmName());
			 pstmt.setString(3, aa.getmDate());
			 pstmt.setString(4, aa.getPublishName());
			 pstmt.setInt(5, aa.getPrice());
			 pstmt.executeUpdate();
		} catch (Exception e) {
		}   
	}
}
