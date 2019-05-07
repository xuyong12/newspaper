package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

import model.Subscribe;
import model.User;

public class UserDao {
	public int get(Connection connection,User user) throws SQLException {       //�Ѷ�����뵽���ݿ⣬ע�Ṧ��
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
		preparedStatement.close();     //�ر�preparedStatement��Դ
		return i;
	}
	public static boolean back(Connection connection,User user) throws SQLException {             //�ж��Ƿ�����ͬ�˺�
		String sql="select uId from user";
		java.sql.Statement state=connection.createStatement();
		ResultSet result=state.executeQuery(sql);
		while(result.next()) {
			if(user.getuId().equals(result.getString(1))) {
				state.close();
				return false;                   //����ͬ�˺ŷ���Ϊfalse;
			}
		}
		state.close();
		return true;              //û����ͬ�˺ŷ���Ϊtrue
	}
	public static boolean back(Connection con,String id) throws SQLException {    //�ж��Ƿ�����ͬ��id
		String sql="select uId from user where uId=?";
		PreparedStatement st=con.prepareStatement(sql);
		st.setString(1, id);
		ResultSet set=st.executeQuery();
		if(set.next()) {
			set.close();    //�ر���Դ
			st.close();
			return true;           //��ʱ����Ϊtrue
		}else {
			return false;            //û��ʱ����Ϊfalse
		}
	}
	public static ResultSet log(Connection connection) throws SQLException {                  //��½��ѯ�Ƿ��д���
		String sql="select uId,uPassword from user ";  
		PreparedStatement state=connection.prepareStatement(sql);
		ResultSet set=state.executeQuery();
		/*state.close();          //�ر���Դ
*/		return set;
	}
	public static ResultSet sp(Connection connection,String uId) throws SQLException {        //�û��޸�
		String sql="select * from user where uId=?";
		PreparedStatement statement=connection.prepareStatement(sql);
		statement.setString(1,uId);
		ResultSet result=statement.executeQuery();
		/*statement.close();           //�ر���Դ
*/		return result;
	}
	public static void delete(Connection connection,String uId) {         //ɾ������
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
	public static void update(Connection con,Subscribe sub) throws SQLException {      //���û����ĳɹ�������û��Ķ�������
		String sql="update user set usNumber=usNumber+? where uId=?";
		PreparedStatement state=con.prepareStatement(sql);
		state.setInt(1,sub.getsNumber());
		state.setString(2, ""+sub.getsUserID());
		state.executeUpdate();
	}
}
