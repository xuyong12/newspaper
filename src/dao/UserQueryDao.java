package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Subscribe;

public class UserQueryDao {
    public static ResultSet get(Connection con,String id) throws SQLException {       //�õ��û��Ķ�����Ϣ
    	String sql="select * from  userquery where userquery.sUserID=?";
    	PreparedStatement state=con.prepareStatement(sql);
    	state.setString(1, id);
    	ResultSet set=state.executeQuery();
    	return set;
    }
    public static boolean exist(Connection con,String id) throws SQLException {        //�鿴�û��Ƿ���ڶ�����Ϣ
    	String sql="select * from userquery where sUserID=?";
    	PreparedStatement state=con.prepareStatement(sql);
    	state.setString(1, id);
    	ResultSet set=state.executeQuery();
    	if(set.next()) {
    		return true;            //���ڷ���true
    	}else {
    		return false;           //�����ڷ���false
    	}
    }
}
