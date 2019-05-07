package newspaper1;

public class Ab_add {
	private String uName;
	private String uId;
	private String uPassword;
	private String uSex;
	private String uAddress;
	private String uTelephone;
	private String uEmail;
	private int uDepartmentID;
	private int usNumber;
	
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getuPassword() {
		return uPassword;
	}
	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}
	public String getuSex() {
		return uSex;
	}
	public void setuSex(String uSex) {
		this.uSex = uSex;
	}
	public String getuAddress() {
		return uAddress;
	}
	public void setuAddress(String uAddress) {
		this.uAddress = uAddress;
	}
	public String getuTelephone() {
		return uTelephone;
	}
	public void setuTelephone(String uTelephone) {
		this.uTelephone = uTelephone;
	}
	public String getuEmail() {
		return uEmail;
	}
	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}
	public int getuDepartmentID() {
		return uDepartmentID;
	}
	public void setuDepartmentID(String UDepartmentID) {
		int uDepartmentID=Integer.parseInt(UDepartmentID);
		this.uDepartmentID = uDepartmentID;
	}
	public int getUsNumber() {
		return usNumber;
	}
	public void setUsNumber(String UsNumber) {
		int usNumber=Integer.parseInt(UsNumber);
		this.usNumber = usNumber;
	}
}
