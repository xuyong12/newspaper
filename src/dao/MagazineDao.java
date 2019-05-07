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
    	/* statement.close();    //关闭资源
*/    	 return set;
     }
     public static ResultSet getUName(Connection con) throws SQLException {
    	 String sql="select mName from magazine";
    	 PreparedStatement statement=con.prepareStatement(sql);
    	 ResultSet set=statement.executeQuery();
    	/* statement.close();        //关闭资源
*/    	 return set;
     }
     public static ResultSet getUName(Connection connection,int id) throws SQLException {
		String sql = "select mName from magazine where mId=?";
		ResultSet set;
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);
		set = statement.executeQuery();
		/*statement.close();         //关闭资源
*/		return set;
     }
     public static boolean hasMId(Connection connection,int id) throws SQLException {         //判断是否有这个书的编号
    	 String sql="select mId from magazine where mId=?";
    	 PreparedStatement st=connection.prepareStatement(sql);
    	 st.setInt(1, id);
    	 ResultSet set=st.executeQuery();
    	 if(set.next()) {
    		 set.close();         //关闭资源
    		 st.close();
    		 return true;         //有时就返回true；
    	 }else {
    		 set.close();      //关闭资源
    		 st.close();
    		 return false;             //没有就返回false
    	 }
     }
     public static boolean hasMatches(Connection con,int id,String name) throws SQLException {     //判断报刊编号与报刊名字是否对应
		String sql = "select mName from magazine where mId=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, id);
		ResultSet set = st.executeQuery();
		if (set.next()) {
			if (name.equals(set.getString(1))) {
				set.close();                //关闭资源
				st.close();
				return true; // 名字相同返回true
			} else {
				set.close();
				st.close();
				return false; // 名字不对应返回为false
			}
		}return false;            //没有对应的名字
	}
     public static int getPrice(Connection con,Subscribe sub) throws SQLException {         //根据订阅表里的订阅报纸来获取价格
    	 String sql="select price from magazine,subscribe where mid=?";
    	 PreparedStatement state=con.prepareStatement(sql);
    	 state.setInt(1, sub.getsMagazineID());
    	 ResultSet set=state.executeQuery();
    	 if(set.next()) {
    		/* set.close();            //关闭资源
    		 state.close();*/
    		 return set.getInt(1);
    	 }else {
    		/* set.close();            //关闭资源
    		 state.close();*/
    		 return 0;          //返回0时表示出错了
    	 }
     }
     public static String found(Connection con,Subscribe sub) throws SQLException {           //根据杂志id来获取杂志名字
    	 String sql="select mName from magazine where mId=?";
    	 PreparedStatement st=con.prepareStatement(sql);
         st.setInt(1,sub.getsMagazineID());
         ResultSet set=st.executeQuery();
         if(set.next()) {
        	 return set.getString(1);            //当存在时返回名字
         }else {
        	 return null;           //不存在时返回null
         }
     }
}
