package test01;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

public class departmentlist extends Jdbc{
	public departmentlist() throws SQLException {
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
		Vector<Vector<String>> ve=new Vector();
		String sql="select * from department";
		try {
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				Vector v=new Vector();
				String dID=rs.getString(1);
				v.add(dID);
				String dName=rs.getString(2);
				v.add(dName);
				ve.add(v);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ve;
	}
	public boolean compareName(String name) {
		boolean n=false;
		String sql="select dID from department";
		try {
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				String did=rs.getString(1);
				if(did.equals(name)) {
					n=true;
				}
			}
			rs.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
	
	public String[] Depart(String name) {
		String sql="select * from department";
		String[] s=new String[2];
		try {
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				String dID=rs.getString(1);
				String dName=rs.getString(2);
				if(dID.equals(name)) {
					s[0]=dID;
					s[1]=dName;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
}
