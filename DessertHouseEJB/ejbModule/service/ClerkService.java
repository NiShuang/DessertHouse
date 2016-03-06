package service;

import java.util.List;

import javax.ejb.Remote;

import model.Clerk;

@Remote
public interface ClerkService {

	public void add(String name,String password,int store,String telephone);
	
	public void remove(String id);
	
	public Clerk find(String id);
	
	public void update(String id,String name,int store,String telephone);
	
	public String getNewId();
	
	public List findByStore(int store);
	
	public List findAll();
}
