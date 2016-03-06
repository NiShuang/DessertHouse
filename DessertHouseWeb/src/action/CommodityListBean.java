package action;

import java.io.Serializable;
import java.util.List;

import model.Commodity;

public class CommodityListBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private List commodityList;

	
	public List getCommodityList() {
		return commodityList;
	}

	
	public void setCommodityList(List commodityList) {
		this.commodityList = commodityList;
	}
	
	
	public void setCommodityList(Commodity commodity, int index) {
		commodityList.set(index, commodity);
		}
	
	public Commodity getCommodityList(int index) {
		return (Commodity) commodityList.get(index);
	}
}
