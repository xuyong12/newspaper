package model;

public class Subscribe {
	private int sUserID;
	private int sMagazineID;
	private int sNumber;
	private int sDtate;
	public Subscribe(int sUserID, int sMagazineID, int sNumber, int sDtate) {       //传入一个没有价格的对象
		super();
		this.sUserID = sUserID;
		this.sMagazineID = sMagazineID;
		this.sNumber = sNumber;
		this.sDtate = sDtate;
	}

	public int getsUserID() {
		return sUserID;
	}

	public void setsUserID(int sUserID) {
		this.sUserID = sUserID;
	}

	public int getsMagazineID() {
		return sMagazineID;
	}

	public void setsMagazineID(int sMagazineID) {
		this.sMagazineID = sMagazineID;
	}

	public int getsNumber() {
		return sNumber;
	}

	public void setsNumber(int sNumber) {
		this.sNumber = sNumber;
	}

	public int getsDtate() {
		return sDtate;
	}

	public void setsDtate(int sDtate) {
		this.sDtate = sDtate;
	}
}
