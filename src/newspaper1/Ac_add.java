package newspaper1;

public class Ac_add {
	private int dID;
	private String dName;
	
	public int getdID() {
		return dID;
	}
	public void setdID(String ID) {
		int dID=Integer.parseInt(ID);
		this.dID = dID;
	}
	public String getdName() {
		return dName;
	}
	public void setdName(String dName) {
		this.dName = dName;
	}
}
