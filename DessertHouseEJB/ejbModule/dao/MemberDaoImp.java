package dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Member;


/**
 * Session Bean implementation class MemberDaoImp
 */
@Stateless
//@LocalBean
public class MemberDaoImp implements MemberDao {
	@PersistenceContext(unitName = "DessertHouseJPA" )
	protected EntityManager em;
	private static MemberDaoImp memberDao=new MemberDaoImp();

	
	private MemberDaoImp()
	{
		
	}
	
	public static MemberDaoImp getInstance()
	{
		return memberDao;
	}

	@Override
	public Member find(String id) {
		// TODO Auto-generated method stub
		Member member = em.find(Member.class, id);	
		return member;
	}

	@Override
	public void save(Member member) {
		// TODO Auto-generated method stub
		try {
			em.persist(member); 
		}catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Override
	public void updateById(Member member) {
		// TODO Auto-generated method stub
		try {
			em.merge(member); 
		}catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Override
	public int getMaxId() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("from Member order by id desc");
		query.setMaxResults(1);
		List list = query.getResultList();
		if(list==null)
			return 0;
		else if(list.size()==0)
			return 0;
		else{
			Member member = (Member)list.get(0);
			return Integer.parseInt(member.getId());
		}
	}

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("from Member");
		List list = query.getResultList();
		return list;
	}
	
	@Override
	public List sexStatistics() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select m.sex,count(m) from Member m group by m.sex");
		List list = query.getResultList();
		return list;
	}

	@Override
	public List placeStatistics() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select m.place,count(m) from Member m group by m.place");
		List list = query.getResultList();
		return list;
	}
	
	@Override
	public List ageStatistics() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select case when ((Year(current_date())-Year(birthday)) <=20) then '20岁以下' when ((Year(current_date())-Year(birthday)) >=21 and (Year(current_date())-Year(birthday)) <=40) then '21-40岁'  else '40岁以上' end , count(*)  from Member group  by case when ((Year(current_date())-Year(birthday)) <=20) then '0-20' when ((Year(current_date())-Year(birthday)) >=21 and (Year(current_date())-Year(birthday)) <=40) then '21-40'  else '40以上' end");
		List list = query.getResultList();
		return list;
	}

	@Override
	public List consumeStatistics() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select case when (expense <=100) then '100元以下' when (100<expense and expense<=500 )  then '100-500元' when (500<expense and expense<=2000 )  then '500-2000元' when (2000<expense and expense<=10000 )  then '2000-10000元' else '10000元以上' end , count(*)  from Member group  by case when (expense <=100) then '100元以下' when (100<expense and expense<=500 )  then '100-500元' when (500<expense and expense<=2000 )  then '500-2000元' when (2000<expense and expense<=10000 )  then '2000-10000元' else '10000元以上' end ");
		List list = query.getResultList();
		return list;
	}
	
	@Override
	public List cardStatistics() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select m.is_active,count(m) from Member m group by m.is_active");
		List list = query.getResultList();
		return list;
	}
}
