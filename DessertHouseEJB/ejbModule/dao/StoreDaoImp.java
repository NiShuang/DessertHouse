package dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Clerk;
import model.Member;
import model.Store;

/**
 * Session Bean implementation class StoreDaoImp
 */
@Stateless
//@LocalBean
public class StoreDaoImp implements StoreDao {

	@PersistenceContext(unitName = "DessertHouseJPA" )
	protected EntityManager em;
	private static StoreDaoImp storeDao = new StoreDaoImp();

	
	private StoreDaoImp()
	{
		
	}
	
	public static StoreDaoImp getInstance()
	{
		return storeDao;
	}

	@Override
	public Store find(int id) {
		// TODO Auto-generated method stub
		Store store = em.find(Store.class, id);	
		return store;
	}

	@Override
	public void save(Store store) {
		// TODO Auto-generated method stub
		try {
			em.persist(store); 
		}catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Override
	public void updateById(Store store) {
		// TODO Auto-generated method stub
		try {
			em.merge(store); 
		}catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("from Store");
		List list = query.getResultList();
		return list;
	}

	@Override
	public void remove(int id) {
		// TODO Auto-generated method stub
		 Store store = em.find(Store.class,id);
         em.remove(store);
	}

	@Override
	public int getMaxId() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("from Store order by id desc");
		query.setMaxResults(1);
		List list = query.getResultList();
		if(list==null)
			return 0;
		else if(list.size()==0)
			return 0;
		else{
			Store store = (Store)list.get(0);
			return store.getId();
		}
	}


}
