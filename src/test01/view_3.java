package test01;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

public class view_3 extends Jdbc{
	public view_3() throws SQLException {
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
		String sql="select * from view_3";
		Vector<Vector<String>> ve=new Vector();
		try {
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				Vector v=new Vector();
				String uId=rs.getString(1);
				v.add(uId);
				String uName=rs.getString(2);
				v.add(uName);
				String mName=rs.getString(3);
				v.add(mName);
				String sNumber=rs.getString(4);
				v.add(sNumber);
				
				ve.add(v);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return ve;
	}
	
	public boolean compare(String d) {
		boolean u=false;
		String sql="select uId from view_3";
		try {
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				String uId=rs.getString(1);
				if(uId.equals(d)) {
					u=true;
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	
	public Vector select(String d) {
		Vector<Vector<String>> ve=new Vector();
		String sql="select * from view_3";
		try {
			rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				Vector v=new Vector();
				String uId=rs.getString(1);
				String uName=rs.getString(2);
				String mName=rs.getString(3);
				String sNumber=rs.getString(4);
				if(uId.equals(d)) {
					v.add(uId);
					v.add(uName);
					v.add(mName);
					v.add(sNumber);
					
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
