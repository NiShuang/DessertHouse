package service;

import java.sql.Date;
import java.util.List;

import javax.ejb.Remote;

import model.PlanItem;


@Remote
public interface PlanItemService {
	public void add(int store_id,int commodity_id ,Date date,double price,int quantity);
	
	public void remove(int id);
	
	public PlanItem find(int id);
	
	public void update(int id,double price,int quantity);
	
	public void reserve(int id,int reserve);
	
	public void sell(int id, int sold);
	
	public List findByStore(int store);
	
	public List findAll();
	
	public void approve(int store,Date date);
	
	public void submit(int store,Date date);
	
	public void setApprove(int id,int result);
	
	public List marketStatistics(int store);
	
	public String getHot(int store); 
}
