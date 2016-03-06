package service;

import java.util.List;

import javax.ejb.Remote;

import model.Commodity;

@Remote
public interface CommodityService {
	public void add(String name);
	
	public void remove(int id);
	
	public List findAll();
	
	public Commodity find(int id);
	
	public void update(int id,String name);
}
