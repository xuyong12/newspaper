package test01;

import java.sql.*;

import javax.swing.JOptionPane;

public class Adminuser {
	Connection conn=null;
	Statement stmt = null;
	ResultSet rs = null;
	
	String driver="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/newspaper?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false&allowPublicKeyRetrieval=true";
	String name="root";
	String password="6198611nao";
	public Adminuser() throws SQLException {
		try {
			Class.forName(driver).newInstance();
			conn=DriverManager.getConnection(url, name, password);
			//String sql="Select *from Adminuser";
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
	public boolean compare(String Aid, String Aname,String Apassword) {
		boolean m=false;
		String sql="select *from Adminuser";
		try {
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				String id=rs.getString(1);
				String name=rs.getString(2);
				String password=rs.getString(3);
				if(id.equals(Aid)) {
					if(name.equals(Aname)) {
						if(password.equals(Apassword)) {
							m=true;
						}/*else {
							JOptionPane.showMessageDialog(null, "密码错误！");
						}*/
					}/*else {
						JOptionPane.showMessageDialog(null, "管理员名错误");
					}*/
				}/*else {
					JOptionPane.showMessageDialog(null, "用户不存在！");
				}*/
			}
			rs.close();
			conn.close();
			stmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return m;
		
	}
}
