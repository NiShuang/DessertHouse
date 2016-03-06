package dao;

import java.sql.Date;
import java.util.List;

import javax.ejb.Remote;

import model.PlanItem;

@Remote
public interface PlanItemDao {
	public PlanItem find(int id);
	
	public void updateById(PlanItem planItem);
	
	public void save(PlanItem planItem);
	
	public void remove(int id);
	
	public List findAll();
	
	public List findByStore(int store);
	
	public List findByStoreDate(int store,Date date);
	
	public List marketStatictis(int store);
	
	public List getHot(int store);
}
