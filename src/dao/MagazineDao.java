package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Subscribe;

public class MagazineDao {
     public static  ResultSet get(Connection con) throws SQLException {
    	 String sql="select * from magazine";
    	 PreparedStatement statement=con.prepareStatement(sql);
    	 ResultSet set=statement.executeQuery();
    	/* statement.close();    //�ر���Դ
*/    	 return set;
     }
     public static ResultSet getUName(Connection con) throws SQLException {
    	 String sql="select mName from magazine";
    	 PreparedStatement statement=con.prepareStatement(sql);
    	 ResultSet set=statement.executeQuery();
    	/* statement.close();        //�ر���Դ
*/    	 return set;
     }
     public static ResultSet getUName(Connection connection,int id) throws SQLException {
		String sql = "select mName from magazine where mId=?";
		ResultSet set;
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);
		set = statement.executeQuery();
		/*statement.close();         //�ر���Դ
*/		return set;
     }
     public static boolean hasMId(Connection connection,int id) throws SQLException {         //�ж��Ƿ��������ı��
    	 String sql="select mId from magazine where mId=?";
    	 PreparedStatement st=connection.prepareStatement(sql);
    	 st.setInt(1, id);
    	 ResultSet set=st.executeQuery();
    	 if(set.next()) {
    		 set.close();         //�ر���Դ
    		 st.close();
    		 return true;         //��ʱ�ͷ���true��
    	 }else {
    		 set.close();      //�ر���Դ
    		 st.close();
    		 return false;             //û�оͷ���false
    	 }
     }
     public static boolean hasMatches(Connection con,int id,String name) throws SQLException {     //�жϱ�������뱨�������Ƿ��Ӧ
		String sql = "select mName from magazine where mId=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, id);
		ResultSet set = st.executeQuery();
		if (set.next()) {
			if (name.equals(set.getString(1))) {
				set.close();                //�ر���Դ
				st.close();
				return true; // ������ͬ����true
			} else {
				set.close();
				st.close();
				return false; // ���ֲ���Ӧ����Ϊfalse
			}
		}return false;            //û�ж�Ӧ������
	}
     public static int getPrice(Connection con,Subscribe sub) throws SQLException {         //���ݶ��ı���Ķ��ı�ֽ����ȡ�۸�
    	 String sql="select price from magazine,subscribe where mid=?";
    	 PreparedStatement state=con.prepareStatement(sql);
    	 state.setInt(1, sub.getsMagazineID());
    	 ResultSet set=state.executeQuery();
    	 if(set.next()) {
    		/* set.close();            //�ر���Դ
    		 state.close();*/
    		 return set.getInt(1);
    	 }else {
    		/* set.close();            //�ر���Դ
    		 state.close();*/
    		 return 0;          //����0ʱ��ʾ������
    	 }
     }
     public static String found(Connection con,Subscribe sub) throws SQLException {           //������־id����ȡ��־����
    	 String sql="select mName from magazine where mId=?";
    	 PreparedStatement st=con.prepareStatement(sql);
         st.setInt(1,sub.getsMagazineID());
         ResultSet set=st.executeQuery();
         if(set.next()) {
        	 return set.getString(1);            //������ʱ��������
         }else {
        	 return null;           //������ʱ����null
         }
     }
}
