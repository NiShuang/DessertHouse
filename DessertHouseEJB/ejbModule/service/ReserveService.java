package service;

import java.sql.Date;
import java.util.List;

import javax.ejb.Remote;

import model.Reserve;

@Remote
public interface ReserveService {
	public boolean add(String member_id,int planItem_id,int quantity,double discount);
	
	public void cancel(int id);
	
	public Reserve find(int id);
	
//	public void update(int id,double price,int quantity);
	
	public List findByMember(String member);
	
	public List findAll();
	
	public List findToPayByMember(String member);
	
	public void sellReserve(int id,String clerk) ;
}
