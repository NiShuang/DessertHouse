package action;

import java.io.Serializable;
import java.util.List;

import model.Store;

public class StoreListBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private List storeList;

	
	public List getStoreList() {
		return storeList;
	}

	
	public void setStoreList(List storeList) {
		this.storeList = storeList;
	}
	
	
	public void setStoreList(Store store, int index) {
		storeList.set(index, store);
		}
	
	public Store getStoreList(int index) {
		return (Store) storeList.get(index);
	}
}
