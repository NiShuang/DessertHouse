package dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.PaymentRecord;

/**
 * Session Bean implementation class PaymentRecordDaoImp
 */
@Stateless
//@LocalBean
public class PaymentRecordDaoImp implements PaymentRecordDao {

	@PersistenceContext(unitName = "DessertHouseJPA" )
	protected EntityManager em;
	private static PaymentRecordDaoImp paymentRecordDao =new PaymentRecordDaoImp();

	
	private PaymentRecordDaoImp()
	{
		
	}
	
	public static PaymentRecordDaoImp getInstance()
	{
		return paymentRecordDao;
	}

	@Override
	public List findRecordByMember(String memberId) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("from PaymentRecord where member_id = ?1");
		query.setParameter(1, memberId);
		List list = query.getResultList();
		return list;
	}

	@Override
	public void save(PaymentRecord paymentRecord) {
		// TODO Auto-generated method stub
		try {
			em.persist(paymentRecord); 
		}catch (Exception e) {
			e.printStackTrace();

		}
	}


}
