package dao;

import java.util.List;

import javax.ejb.Remote;

import model.Plan;


@Remote
public interface PlanDao {
	public Plan find(int id);
	
	public void save(Plan plan);
	
	public void updateById(Plan plan);
	
	public List findAll();
	
	public void remove(int id);

}
