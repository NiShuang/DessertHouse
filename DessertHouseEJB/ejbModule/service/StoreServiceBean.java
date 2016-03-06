package service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import dao.StoreDao;
import model.Store;

/**
 * Session Bean implementation class StoreServiceBean
 */
@Stateless
//@LocalBean
public class StoreServiceBean implements StoreService {

	@EJB StoreDao storeDao;
    public StoreServiceBean() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public Store add(String name, String location, String telephone) {
		// TODO Auto-generated method stub
		int id = getNewId();
		Store store = new Store();
		store.setId(id);
		store.setName(name);
		store.setLocation(location);
		store.setTelephone(telephone);
		storeDao.save(store);
		return store;
	}
	@Override
	public void remove(int id) {
		// TODO Auto-generated method stub
		storeDao.remove(id);
	}
	@Override
	public Store find(int id) {
		// TODO Auto-generated method stub
		return storeDao.find(id);
	}
	@Override
	public void update(int id, String name, String location, String telephone) {
		// TODO Auto-generated method stub
		Store store = storeDao.find(id);
		store.setName(name);
		store.setLocation(location);
		store.setTelephone(telephone);
		storeDao.updateById(store);
	}
	@Override
	public int getNewId() {
		// TODO Auto-generated method stub
		return storeDao.getMaxId()+1;
	}
	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return storeDao.findAll();
	}

	
}
