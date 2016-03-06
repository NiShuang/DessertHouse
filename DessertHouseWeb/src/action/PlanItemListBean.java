package action;

import java.io.Serializable;
import java.util.List;

import model.PlanItem;

public class PlanItemListBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private List planItemList;

	
	public List getPlanItemList() {
		return planItemList;
	}

	
	public void setPlanItemList(List planItemList) {
		this.planItemList = planItemList;
	}
	
	
	public void setPlanItemList(PlanItem planItem, int index) {
		planItemList.set(index, planItem);
		}
	
	public PlanItem getPlanItemList(int index) {
		return (PlanItem) planItemList.get(index);
	}
}
