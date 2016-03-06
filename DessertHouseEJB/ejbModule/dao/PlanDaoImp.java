package dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Plan;
import model.Store;

/**
 * Session Bean implementation class PlanDaoImp
 */
@Stateless
//@LocalBean
public class PlanDaoImp implements PlanDao {

	@PersistenceContext(unitName = "DessertHouseJPA" )
	protected EntityManager em;
	private static PlanDaoImp planDao = new PlanDaoImp();

	
	private PlanDaoImp()
	{
		
	}
	
	public static PlanDaoImp getInstance()
	{
		return planDao;
	}


	@Override
	public Plan find(int id) {
		// TODO Auto-generated method stub
		Plan plan = em.find(Plan.class, id);	
		return plan;
	}

	@Override
	public void save(Plan plan) {
		// TODO Auto-generated method stub
		try {
			em.persist(plan); 
		}catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Override
	public void updateById(Plan plan) {
		// TODO Auto-generated method stub
		try {
			em.merge(plan); 
		}catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("from Plan");
		List list = query.getResultList();
		return list;
	}

	@Override
	public void remove(int id) {
		// TODO Auto-generated method stub
		Plan plan = em.find(Plan.class,id);
         em.remove(plan);
	}

}
