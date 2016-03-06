package action;

import java.io.Serializable;
import java.util.List;

import model.Reserve;

public class ReserveListBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private List reserveList;

	
	public List getReserveList() {
		return reserveList;
	}

	
	public void setReserveList(List reserveList) {
		this.reserveList = reserveList;
	}
	
	
	public void setReserveList(Reserve reserve, int index) {
		reserveList.set(index, reserve);
		}
	
	public Reserve getReserveList(int index) {
		return (Reserve) reserveList.get(index);
	}
}
