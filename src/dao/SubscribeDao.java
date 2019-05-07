package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Subscribe;

public class SubscribeDao {
	public static void update(Connection con,Subscribe be,int num,int date) throws SQLException {      //���û��Ѿ������ڶ��ı���ʱ��ִ�и������
		String sql="update subscribe set sNumber=sNumber+?,sDate=sDate+? where sUserID=? and sMagazineID=?";     //�ض����û����ض��ı������,
		PreparedStatement state=con.prepareStatement(sql);
		state.setInt(1, num);
		state.setInt(2,date);         //��������
		state.setInt(3, be.getsUserID());
		state.setInt(4, be.getsMagazineID());
		state.executeUpdate();
		state.close();         
	}
	public static boolean exist(Connection con,Subscribe be) throws SQLException {       //���subscribe�����Ƿ��д�����ͬ�û��Ķ�����Ϣ
		String sql="select sUserID from subscribe where sUserID=?";
		PreparedStatement state=con.prepareStatement(sql);
		state.setInt(1, be.getsUserID());
		ResultSet set=state.executeQuery();
		if(set.next()) {
		/*	set.close();
			state.close();*/
			return true;            //���ڷ���true
		}else {
			/*set.close();
			state.close();*/
			return false;           //�����ڷ���false
		}
	}
	public static boolean exist2(Connection con,Subscribe sub) throws SQLException {             //���sunscribe�����Ƿ�����ͬ�ı�������
		String sql="select sMagazineID from subscribe where sMagazineID=? and sUserID=?";
		PreparedStatement state=con.prepareStatement(sql);
		state.setInt(1, sub.getsMagazineID());
		state.setInt(2,sub.getsUserID());         //ҲҪ����û�
		ResultSet set=state.executeQuery();
		if(set.next()) {
			/*set.close();
			state.close();*/
			return true;            //���ڷ���true
		}else {
		/*	set.close();
			state.close();*/
			return false;           //�����ڷ���false
		}
	}
	public static void insert(Connection con,Subscribe be) throws SQLException {       //�����ı�������ݿ�
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
