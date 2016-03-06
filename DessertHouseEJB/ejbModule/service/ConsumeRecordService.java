package service;

import java.util.List;

import javax.ejb.Remote;

import model.ConsumeRecord;

@Remote
public interface ConsumeRecordService {
	public boolean add(String member_id,String clerk_id,int planItem_id,int quantity,double discount);
	
//	public void remove(int id);
	
//	public ConsumeRecord find(int id);
	
//	public void update(int id,double price,int quantity);
	
	public List findByMember(String member);
	
	public List findAll();
}
