package dao;

import java.sql.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.PlanItem;
import model.Store;

/**
 * Session Bean implementation class PlanItemDaoImp
 */
@Stateless
//@LocalBean
public class PlanItemDaoImp implements PlanItemDao {

	@PersistenceContext(unitName = "DessertHouseJPA" )
	protected EntityManager em;
	private static PlanItemDaoImp planItemDao = new PlanItemDaoImp();

	
	private PlanItemDaoImp()
	{
		
	}
	
	public static PlanItemDaoImp getInstance()
	{
		return planItemDao;
	}

	@Override
	public PlanItem find(int id) {
		// TODO Auto-generated method stub
		PlanItem planItem = em.find(PlanItem.class, id);	
		return planItem;
	}

	@Override
	public void updateById(PlanItem planItem) {
		// TODO Auto-generated method stub
		try {
			em.merge(planItem); 
		}catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Override
	public void save(PlanItem planItem) {
		// TODO Auto-generated method stub
		try {
			em.persist(planItem); 
		}catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Override
	public void remove(int id) {
		// TODO Auto-generated method stub
		PlanItem planItem = em.find(PlanItem.class,id);
         em.remove(planItem);
	}

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("from PlanItem");
		List list = query.getResultList();
		return list;
	}

	@Override
	public List findByStore(int store) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List findByStoreDate(int store, Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List marketStatictis(int store) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select c.name,SUM(p.quantity),SUM(p.reserve),SUM(p.sold) from PlanItem p left join p.commodity c left join p.store s where s.id = ?1 and MONTH(p.date)=MONTH(current_date()) and YEAR(p.date)=YEAR(current_date()) and p.state=2  group by c.id");
		query.setParameter(1, store);
		List list = query.getResultList();
		return list;
	}

	@Override
	public List getHot(int store) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select c.name from PlanItem p left join p.commodity c left join p.store s where s.id = ?1 and MONTH(p.date)=MONTH(current_date()) and YEAR(p.date)=YEAR(current_date()) and p.state=2  group by c.id order by SUM(p.sold) DESC");
		query.setParameter(1, store);
		query.setMaxResults(1);
		List list = query.getResultList();
		return list;
	}
	
	

}
