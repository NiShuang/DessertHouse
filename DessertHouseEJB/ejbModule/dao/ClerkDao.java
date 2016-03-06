package dao;

import java.util.List;

import javax.ejb.Remote;

import model.Clerk;


@Remote
public interface ClerkDao {
	public Clerk find(String id);
	
	public void save(Clerk clerk);
	
	public void updateById(Clerk clerk);
	
	public List findAll();
	
	public List findByStore(int id);
	
	public void remove(String id);

	int getMaxId();
}
