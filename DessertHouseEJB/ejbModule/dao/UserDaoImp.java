package dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.User;

/**
 * Session Bean implementation class UserDaoImp
 */
@Stateless
//@LocalBean
public class UserDaoImp implements UserDao {
	@PersistenceContext(unitName = "DessertHouseJPA" )
	protected EntityManager em;
	private static UserDaoImp userDao = new UserDaoImp();

	
	private UserDaoImp()
	{
		
	}
	
	public static UserDaoImp getInstance()
	{
		return userDao;
	}

	@Override
	public User find(String id) {
		// TODO Auto-generated method stub
		User user = em.find(User.class, id);	
		return user;
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		try {
			em.persist(user); 
		}catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Override
	public void updateById(User user) {
		// TODO Auto-generated method stub
		try {
			em.merge(user); 
		}catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Override
	public void remove(String id) {
		// TODO Auto-generated method stub
		User user = em.find(User.class,id);
        em.remove(user);
	}

}
