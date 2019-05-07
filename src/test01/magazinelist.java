package test01;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
public class magazinelist extends Jdbc{
	public magazinelist() throws SQLException {
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
		String sql="select * from magazine";
		try {
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				Vector v=new Vector();
				String mId=rs.getString(1);
				v.add(mId);
				String mName=rs.getString(2);
				v.add(mName);
				String mDate=rs.getString(3);
				v.add(mDate);
				String publishName=rs.getString(4);
				v.add(publishName);
				String price=rs.getString(5);
				v.add(price);
				ve.add(v);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return ve;
	}
	public boolean compareName(String name) {
		boolean n=false;
		String sql="select mId from magazine";
		try {
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				String Mid=rs.getString(1);
				if(Mid.equals(name)) {
					n=true;
				}
			}
			rs.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	public String[] TablePublish(String name) {
		String sql="select * from magazine";
		String[] s=new String[5];
		try {
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				String mId=rs.getString(1);
				String mName=rs.getString(2);
				String mDate=rs.getString(3);
				String publishName=rs.getString(4);
				String price=rs.getString(5);
				if(mId.equals(name)) {
					s[0]=mId;
					s[1]=mName;
					s[2]=mDate;
					s[3]=publishName;
					s[4]=price;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
}
