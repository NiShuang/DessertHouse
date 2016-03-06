package service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import dao.ClerkDao;
import dao.StoreDao;
import dao.UserDao;
import helper.MD5Helper;
import model.Clerk;
import model.Store;
import model.User;

/**
 * Session Bean implementation class ClerkServiceBean
 */
@Stateless
//@LocalBean
public class ClerkServiceBean implements ClerkService {

	@EJB ClerkDao clerkDao;
	@EJB StoreDao storeDao;
	@EJB UserDao userDao;
    @EJB UserService uservice;
    public ClerkServiceBean() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public void add(String name,String password,int store,String telephone) {
		// TODO Auto-generated method stub
		String id = getNewId();
		Store myStore = storeDao.find(store);
		Clerk clerk = new Clerk();
		clerk.setId(id);
		clerk.setName(name);
		clerk.setStore(myStore);
		clerk.setTelephone(telephone);
		myStore.addClerk(clerk);
		storeDao.updateById(myStore);
//		clerkDao.save(clerk);
		
		uservice.register(id, password, 2);
	}
	@Override
	public void remove(String id) {
		// TODO Auto-generated method stub
		Clerk clerk = clerkDao.find(id);
//		clerk.setStore(null);
//		clerkDao.updateById(clerk);
		Store store = clerk.getStore();
		store.removeClerk(clerk);
		storeDao.updateById(store);
		clerkDao.remove(id);
	    userDao.remove(id);
	}
	@Override
	public Clerk find(String id) {
		// TODO Auto-generated method stub
		return clerkDao.find(id);
	}
	@Override
	public void update(String id, String name, int store, String telephone) {
		// TODO Auto-generated method stub
		Clerk clerk = clerkDao.find(id);
		Store myStore = storeDao.find(store);
		clerk.setName(name);
		clerk.setStore(myStore);
		clerk.setTelephone(telephone);
		clerkDao.updateById(clerk);
	}

	@Override
	public String getNewId() {
		// TODO Auto-generated method stub
		int maxId = clerkDao.getMaxId();
		maxId++;
		String newId = String.valueOf(maxId);
		int count = 1;
		while(maxId/10!=0){
			count++;
			maxId/=10;
		}
		if(count<5){
			 for(int i = 0;i<5-count;i++){
				 newId = "0"+newId;
			 }
		}
		return newId;
	}
	@Override
	public List findByStore(int store) {
		// TODO Auto-generated method stub
		return clerkDao.findByStore(store);
	}
	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return clerkDao.findAll();
	}
}
