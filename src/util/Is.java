package util;

public class Is {
	public static  boolean isEmpty(String s) {
		if(s.equals("")||s==null) {
			return true;         //为空时返回为true
		}
		return false;        //不为空时返回为false
	}
}
