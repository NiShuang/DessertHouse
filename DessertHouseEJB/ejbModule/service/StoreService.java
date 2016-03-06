package service;

import java.util.List;

import javax.ejb.Remote;

import model.Store;

@Remote
public interface StoreService {
	public Store add(String name,String location,String telephone);
	
	public void remove(int id);
	
	public List findAll();
	
	public Store find(int id);
	
	public void update(int id,String name,String location,String telephone);
	
	public int getNewId();
}
