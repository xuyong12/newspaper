package test01;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

public class userslist extends Jdbc{
	public userslist() throws SQLException {
		try {
			Class.forName(driver).newInstance();
			conn=DriverManager.getConnection(url, name, password);
			stmt=conn.createStatement();
		}catch(ClassNotFoundException e) {
			System.out.println("Sorry,not find");
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public Vector all() {
		String sql="select * from user";
		Vector<Vector<String>> ve=new Vector();
		
		try {
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				Vector v=new Vector();
				String uId=rs.getString(1);
				v.add(uId);
				String uPassword=rs.getString(2);
				v.add(uPassword);
				String uName=rs.getString(3);
				v.add(uName);
				String uSex=rs.getString(4);
				v.add(uSex);
				String uAddress=rs.getString(5);
				v.add(uAddress);
				String uTelephone=rs.getString(6);
				v.add(uTelephone);
				String uEmail=rs.getString(7);
				v.add(uEmail);
				String uDepartmentID=""+rs.getInt(8);
				v.add(uDepartmentID);
				String usNumber=""+rs.getInt(9);
				v.add(usNumber);
				ve.add(v);
			}	
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return ve;
	}
	public boolean compareName(String name) {
		boolean n=false;
		String sql="select uId from user";
		try {
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				String Mname=rs.getString(1);
				if(Mname.equals(name)) {
					n=true;
				}
			}
			rs.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
	
	public String[] U(String name) {
		String[] user=new String[9];
		String sql="select * from user";
		try {
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				String uId=rs.getString(1);
				String uPassword=rs.getString(2);
				String uName=rs.getString(3);
				//System.out.println(uName);
				String uSex=rs.getString(4);
				String uAddress=rs.getString(5);
				String uTelephone=rs.getString(6);
				String uEmail=rs.getString(7);
				String uDepartmentID=""+rs.getInt(8);
				String usNumber=""+rs.getInt(9);
				if(uId.equals(name)) {
					user[0]=uId;
					user[1]=uPassword;
					user[2]=uName;
					user[3]=uSex;
					user[4]=uAddress;
					user[5]=uTelephone;
					user[6]=uEmail;
					user[7]=uDepartmentID;
					user[8]=usNumber;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	public void delete(String id) throws SQLException {
		PreparedStatement pstmt=null;
		
		String sql="delete  from user where uId=?";
		pstmt=(PreparedStatement) conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.executeUpdate();
	}

	public void delete2(String id) throws SQLException {
		PreparedStatement pstmt = null;
		String sql = "delete from subscribe where sUserID=?";
		pstmt = (PreparedStatement) conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.executeUpdate();
	}
}
