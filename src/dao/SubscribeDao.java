package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Subscribe;

public class SubscribeDao {
	public static void update(Connection con,Subscribe be,int num,int date) throws SQLException {      //当用户已经存在于订阅表里时，执行更新语句
		String sql="update subscribe set sNumber=sNumber+?,sDate=sDate+? where sUserID=? and sMagazineID=?";     //特定的用户，特定的报刊编号,
		PreparedStatement state=con.prepareStatement(sql);
		state.setInt(1, num);
		state.setInt(2,date);         //增加天数
		state.setInt(3, be.getsUserID());
		state.setInt(4, be.getsMagazineID());
		state.executeUpdate();
		state.close();         
	}
	public static boolean exist(Connection con,Subscribe be) throws SQLException {       //检查subscribe表中是否有存在相同用户的订阅信息
		String sql="select sUserID from subscribe where sUserID=?";
		PreparedStatement state=con.prepareStatement(sql);
		state.setInt(1, be.getsUserID());
		ResultSet set=state.executeQuery();
		if(set.next()) {
		/*	set.close();
			state.close();*/
			return true;            //存在返回true
		}else {
			/*set.close();
			state.close();*/
			return false;           //不存在返回false
		}
	}
	public static boolean exist2(Connection con,Subscribe sub) throws SQLException {             //检查sunscribe表中是否有相同的报刊类型
		String sql="select sMagazineID from subscribe where sMagazineID=? and sUserID=?";
		PreparedStatement state=con.prepareStatement(sql);
		state.setInt(1, sub.getsMagazineID());
		state.setInt(2,sub.getsUserID());         //也要添加用户
		ResultSet set=state.executeQuery();
		if(set.next()) {
			/*set.close();
			state.close();*/
			return true;            //存在返回true
		}else {
		/*	set.close();
			state.close();*/
			return false;           //不存在返回false
		}
	}
	public static void insert(Connection con,Subscribe be) throws SQLException {       //将订阅表插入数据库
		String sql="insert into subscribe(sUserID,sMagazineID,sNumber,sDate)values(?,?,?,?)";
		PreparedStatement state=con.prepareStatement(sql);
		state.setInt(1, be.getsUserID());
		state.setInt(2, be.getsMagazineID());
		state.setInt(3, be.getsNumber());
		state.setInt(4, be.getsDtate());
		state.executeUpdate();
		state.close();
	}
}
