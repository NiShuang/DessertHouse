package dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Reserve;

/**
 * Session Bean implementation class ReserveDaoImp
 */
@Stateless
//@LocalBean
public class ReserveDaoImp implements ReserveDao {
	@PersistenceContext(unitName = "DessertHouseJPA" )
	protected EntityManager em;
	private static ReserveDaoImp reserveDao = new ReserveDaoImp();

	
	private ReserveDaoImp()
	{
		
	}
	
	public static ReserveDaoImp getInstance()
	{
		return reserveDao;
	}

	@Override
	public Reserve find(int id) {
		// TODO Auto-generated method stub
		Reserve Reserve = em.find(Reserve.class, id);	
		return Reserve;
	}

	@Override
	public void updateById(Reserve reserve) {
		// TODO Auto-generated method stub
		try {
			em.merge(reserve); 
		}catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Override
	public void save(Reserve reserve) {
		// TODO Auto-generated method stub
		try {
			em.persist(reserve); 
		}catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Override
	public void remove(int id) {
		// TODO Auto-generated method stub
		Reserve Reserve = em.find(Reserve.class,id);
        em.remove(Reserve);
	}

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("from Reserve");
		List list = query.getResultList();
		return list;
	}

	@Override
	public List findByMember(String member) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("from Reserve r where r.member = ?0");
		query.setParameter(0, member);
		List list = query.getResultList();
		return list;
	}
	
	@Override
	public List findToPayByMember(String member) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("from Reserve r where r.member = ?0 and r.isPay=0");
		query.setParameter(0, member);
		List list = query.getResultList();
		return list;
	}

}
