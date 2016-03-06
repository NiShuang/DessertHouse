package service;

import java.sql.Date;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import dao.UserDao;
import helper.MD5Helper;
import model.User;


/**
 * Session Bean implementation class UserServiceBean
 */
@Stateless
//@LocalBean
public class UserServiceBean implements UserService {

	 @EJB UserDao userDao;
    public UserServiceBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void register(String id, String password, int type) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setId(id);
		user.setPassword(MD5Helper.getMd5(password));
		user.setType(type);
		
		userDao.save(user);
	}

	@Override
	public boolean modifyPassword(String id, String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		User user = userDao.find(id);
		if(!user.getPassword().equals(MD5Helper.getMd5(oldPassword)))
			return false;
		else 
		    user.setPassword(MD5Helper.getMd5(newPassword));
		userDao.updateById(user);
		return true;
	}

	@Override
	public int login(String id, String password) {
		// TODO Auto-generated method stub
		User user = userDao.find(id);
		if(user==null)
			return -1;
		else if(!user.getPassword().equals(MD5Helper.getMd5(password)))
			return 0;
		else return user.getType();
	}

	@Override
	public User find(String id) {
		// TODO Auto-generated method stub
		return userDao.find(id);
	}

}
