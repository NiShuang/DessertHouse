package dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.ConsumeRecord;

/**
 * Session Bean implementation class ConsumeRecordDaoImp
 */
@Stateless
//@LocalBean
public class ConsumeRecordDaoImp implements ConsumeRecordDao {

	@PersistenceContext(unitName = "DessertHouseJPA" )
	protected EntityManager em;
	private static ConsumeRecordDaoImp consumeRecordDaoImp =new ConsumeRecordDaoImp();

	
	private ConsumeRecordDaoImp()
	{
		
	}
	
	public static ConsumeRecordDaoImp getInstance()
	{
		return consumeRecordDaoImp;
	}

	@Override
	public List findRecordByMember(String memberId) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("from ConsumeRecord c where c.member = ?1");
		query.setParameter(1, memberId);
		List list = query.getResultList();
		return list;
	}

	@Override
	public void save(ConsumeRecord consumeRecord) {
		// TODO Auto-generated method stub
		try {
			em.persist(consumeRecord); 
		}catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("from ConsumeRecord");
		List list = query.getResultList();
		return list;
	}

}
