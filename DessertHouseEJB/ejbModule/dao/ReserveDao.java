package dao;

import java.util.List;

import javax.ejb.Remote;

import model.Reserve;

@Remote
public interface ReserveDao {
	public Reserve find(int id);
	
	public void updateById(Reserve reserve);
	
	public void save(Reserve reserve);
	
	public void remove(int id);
	
	public List findAll();
	
	public List findByMember(String member);
	
	public List findToPayByMember(String member);
}
