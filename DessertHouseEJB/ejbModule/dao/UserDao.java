package dao;

import javax.ejb.Remote;

import model.User;

@Remote
public interface UserDao {
	public User find(String id);
	
	public void save(User user);
	
	public void updateById(User user);
	
	public void remove(String id);
}
