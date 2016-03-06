package action;

import java.io.Serializable;
import java.util.Date;
import java.util.List;



public class DateListBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private List dateList;

	
	public List getDateList() {
		return dateList;
	}

	
	public void setDateList(List dateList) {
		this.dateList = dateList;
	}
	
	
	public void setDateList(Date date, int index) {
		dateList.set(index, date);
		}
	
	public Date getDateList(int index) {
		return (Date) dateList.get(index);
	}
}
