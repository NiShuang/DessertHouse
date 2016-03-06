package action;

import java.io.Serializable;
import java.util.List;

import model.Clerk;

public class ClerkListBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private List clerkList;

	
	public List getClerkList() {
		return clerkList;
	}

	
	public void setClerkList(List clerkList) {
		this.clerkList = clerkList;
	}
	
	
	public void setClerkList(Clerk clerk, int index) {
		clerkList.set(index, clerk);
		}
	
	public Clerk getClerkList(int index) {
		return (Clerk) clerkList.get(index);
	}
}
