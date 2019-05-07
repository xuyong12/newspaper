package test01;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

public class view_2 extends Jdbc{
	public view_2() throws SQLException {
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
		String sql="select * from view_2";
		Vector<Vector<String>> ve=new Vector();
		try {
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				Vector v=new Vector();
				String mId=rs.getString(1);
				v.add(mId);
				String mName=rs.getString(2);
				v.add(mName);
				String sNumber=rs.getString(3);
				v.add(sNumber);
				
				ve.add(v);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return ve;
	}
	
	public boolean compare(String d) {
		boolean m=false;
		String sql="select mId from view_2";
		try {
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				String mId=rs.getString(1);
				if(mId.equals(d)) {
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
		String sql="select * from view_2";
		try {
			rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				Vector v=new Vector();
				String mId=rs.getString(1);
				String mName=rs.getString(2);
				String sNumber=rs.getString(3);
				if(mId.equals(d)) {
					v.add(mId);
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
