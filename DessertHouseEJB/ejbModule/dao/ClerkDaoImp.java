package dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Clerk;
import model.Store;

/**
 * Session Bean implementation class ClerkDaoImp
 */
@Stateless
//@LocalBean
public class ClerkDaoImp implements ClerkDao {
	@PersistenceContext(unitName = "DessertHouseJPA" )
	protected EntityManager em;
	private static ClerkDaoImp clerkDao = new ClerkDaoImp();

	
	private ClerkDaoImp()
	{
		
	}
	
	public static ClerkDaoImp getInstance()
	{
		return clerkDao;
	}

	@Override
	public Clerk find(String id) {
		// TODO Auto-generated method stub
		Clerk clerk = em.find(Clerk.class, id);	
		return clerk;
	}

	@Override
	public void save(Clerk clerk) {
		// TODO Auto-generated method stub
		try {
			em.persist(clerk); 
		}catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Override
	public void updateById(Clerk clerk) {
		// TODO Auto-generated method stub
		try {
			em.merge(clerk); 
		}catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("from Clerk");
		List list = query.getResultList();
		return list;
	}

	@Override
	public List findByStore(int id) {
		// TODO Auto-generated method stub
//		Query query = em.createQuery("from Clerk where store = ?1 ");
//		query.setParameter(1, id);
//		List list = query.getResultList();
//		return list;
		return null;
	}

	@Override
	public void remove(String id) {
		// TODO Auto-generated method stub
		Clerk clerk = em.find(Clerk.class,id);
        em.remove(clerk);
	}
	
	@Override
	public int getMaxId() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("from Clerk order by id desc");
		query.setMaxResults(1);
		List list = query.getResultList();
		if(list==null)
			return 0;
		else if(list.size()==0)
			return 0;
		else{
			Clerk clerk = (Clerk)list.get(0);
			return Integer.parseInt(clerk.getId());
		}
	}

}
