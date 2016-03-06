package dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Clerk;
import model.Commodity;

/**
 * Session Bean implementation class CommodityDaoImp
 */
@Stateless
//@LocalBean
public class CommodityDaoImp implements CommodityDao {
	@PersistenceContext(unitName = "DessertHouseJPA" )
	protected EntityManager em;
	private static CommodityDaoImp commodityDao = new CommodityDaoImp();

	
	private CommodityDaoImp()
	{
		
	}
	
	public static CommodityDaoImp getInstance()
	{
		return commodityDao;
	}

	@Override
	public Commodity find(int id) {
		// TODO Auto-generated method stub
		Commodity commodity = em.find(Commodity.class, id);	
		return commodity;
	}

	@Override
	public void save(Commodity commodity) {
		// TODO Auto-generated method stub
		try {
			em.persist(commodity); 
		}catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Override
	public void updateById(Commodity commodity) {
		// TODO Auto-generated method stub
		try {
			em.merge(commodity); 
		}catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("from Commodity");
		List list = query.getResultList();
		return list;
	}

	@Override
	public void remove(int id) {
		// TODO Auto-generated method stub
		Commodity commodity = em.find(Commodity.class,id);
        em.remove(commodity);
	}

}
