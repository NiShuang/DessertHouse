package service;

import java.sql.Date;

import javax.ejb.Remote;

import model.User;

@Remote
public interface UserService {
	
	public void register(String id,String password,int type);
	
	public User find(String id);
	
	public boolean modifyPassword(String id,String oldPassword,String newPassword);
	
	public int login(String id,String password);

}
