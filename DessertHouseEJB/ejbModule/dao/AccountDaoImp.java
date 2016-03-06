package dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Account;
import model.Clerk;

/**
 * Session Bean implementation class AccountDaoImp
 */
@Stateless
//@LocalBean
public class AccountDaoImp implements AccountDao {
	@PersistenceContext(unitName = "DessertHouseJPA" )
	protected EntityManager em;
	private static AccountDaoImp accountDao = new AccountDaoImp();

	
	private AccountDaoImp()
	{
		
	}
	
	public static AccountDaoImp getInstance()
	{
		return accountDao;
	}

	@Override
	public void updateById(Account account) {
		// TODO Auto-generated method stub
		try {
			em.merge(account); 
		}catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Override
	public Account find(String id) {
		// TODO Auto-generated method stub
		Account account = em.find(Account.class, id);	
		return account;
	}

}
