package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

import model.Subscribe;
import model.User;

public class UserDao {
	public int get(Connection connection,User user) throws SQLException {       //把对象插入到数据库，注册功能
		String sql="insert into user values(?,?,?,?,?,?,?,?,?);";
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1,user.getuId());
		preparedStatement.setString(2,user.getuPassword());
		preparedStatement.setString(3, user.getuName());
		preparedStatement.setString(4, user.getuSex());
		preparedStatement.setString(5,user.getuAddress());
		preparedStatement.setString(6, user.getuTelephone());
		preparedStatement.setString(7, user.getuEmail());
		preparedStatement.setInt(8,user.getuDepartmentID());
		preparedStatement.setInt(9, user.getUsNumber());
		int i= preparedStatement.executeUpdate();
		preparedStatement.close();     //关闭preparedStatement资源
		return i;
	}
	public static boolean back(Connection connection,User user) throws SQLException {             //判断是否有相同账号
		String sql="select uId from user";
		java.sql.Statement state=connection.createStatement();
		ResultSet result=state.executeQuery(sql);
		while(result.next()) {
			if(user.getuId().equals(result.getString(1))) {
				state.close();
				return false;                   //有相同账号返回为false;
			}
		}
		state.close();
		return true;              //没有相同账号返回为true
	}
	public static boolean back(Connection con,String id) throws SQLException {    //判断是否有相同的id
		String sql="select uId from user where uId=?";
		PreparedStatement st=con.prepareStatement(sql);
		st.setString(1, id);
		ResultSet set=st.executeQuery();
		if(set.next()) {
			set.close();    //关闭资源
			st.close();
			return true;           //有时返回为true
		}else {
			return false;            //没有时返回为false
		}
	}
	public static ResultSet log(Connection connection) throws SQLException {                  //登陆查询是否有错误
		String sql="select uId,uPassword from user ";  
		PreparedStatement state=connection.prepareStatement(sql);
		ResultSet set=state.executeQuery();
		/*state.close();          //关闭资源
*/		return set;
	}
	public static ResultSet sp(Connection connection,String uId) throws SQLException {        //用户修改
		String sql="select * from user where uId=?";
		PreparedStatement statement=connection.prepareStatement(sql);
		statement.setString(1,uId);
		ResultSet result=statement.executeQuery();
		/*statement.close();           //关闭资源
*/		return result;
	}
	public static void delete(Connection connection,String uId) {         //删除数据
		String sql="delete from user where uId=?";
		try {
			PreparedStatement statement=connection.prepareStatement(sql);
			statement.setString(1, uId);
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void update(Connection con,Subscribe sub) throws SQLException {      //当用户订阅成功后跟新用户的订阅数量
		String sql="update user set usNumber=usNumber+? where uId=?";
		PreparedStatement state=con.prepareStatement(sql);
		state.setInt(1,sub.getsNumber());
		state.setString(2, ""+sub.getsUserID());
		state.executeUpdate();
	}
}
