package util;

public class Is {
	public static  boolean isEmpty(String s) {
		if(s.equals("")||s==null) {
			return true;         //Ϊ��ʱ����Ϊtrue
		}
		return false;        //��Ϊ��ʱ����Ϊfalse
	}
}
