package newspaper1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Aa_add {
	private int mID;
    private String mName;
    private String mDate;              //出版日期
    private String publishName;
    private int price;
	
    public int getmID() {
		return mID;
	}
	public void setmID(String ID) {
		int mID=Integer.parseInt(ID);
		this.mID = mID;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getmDate() {
		return mDate;
	}
	public void setmDate(String date) {
		this.mDate = date;
	}
	public String getPublishName() {
		return publishName;
	}
	public void setPublishName(String publishName) {
		this.publishName = publishName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(String Price) {
		int price=Integer.parseInt(Price);
		this.price = price;
	}

}
