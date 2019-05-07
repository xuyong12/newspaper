package test01;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

public class view_1 extends Jdbc{
	public view_1() throws SQLException {
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
		String sql="select * from ud";
		Vector<Vector<String>> ve=new Vector();
		try {
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				Vector v=new Vector();
				String dID=rs.getString(1);
				v.add(dID);
				String dName=rs.getString(2);
				v.add(dName);
				String uId=rs.getString(3);
				v.add(uId);
				String uName=rs.getString(4);
				v.add(uName);
				String uSex=rs.getString(5);
				v.add(uSex);
				String usNumber=rs.getString(6);
				v.add(usNumber);
				
				ve.add(v);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return ve;
	}
	
	public boolean compare(String d) {
		boolean m=false;
		String sql="select dID from ud";
		try {
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				String dID=rs.getString(1);
				if(dID.equals(d)) {
					m=true;
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return m;
	}
	
	public Vector select(String d) {
		Vector<Vector<String>> ve=new Vector();
		String sql="select * from ud";
		try {
			rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				Vector v=new Vector();
				String dID=rs.getString(1);
				String dName=rs.getString(2);
				String uId=rs.getString(3);
				String uName=rs.getString(4);
				String uSex=rs.getString(5);
				String usNumber=rs.getString(6);
				if(dID.equals(d)) {
					v.add(dID);
					v.add(dName);
					v.add(uId);
					v.add(uName);
					v.add(uSex);
					v.add(usNumber);
					ve.add(v);
				}
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return ve;
	}
}
