package dao;

import java.util.List;

import javax.ejb.Remote;

import model.Commodity;

@Remote
public interface CommodityDao {
	public Commodity find(int id);
	
	public void save(Commodity commodity);
	
	public void updateById(Commodity commodity);
	
	public List findAll();
	
	public void remove(int id);
}
