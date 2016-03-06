package dao;

import java.util.List;

import javax.ejb.Remote;

import model.Store;


@Remote
public interface StoreDao {

	public Store find(int id);
	
	public void save(Store store);
	
	public void updateById(Store store);
	
	public List findAll();
	
	public void remove(int id);
	
	public int getMaxId();
	
}
