package dao;

import javax.ejb.Remote;

import model.Account;

@Remote
public interface AccountDao {
	public void updateById(Account account);
	
	public Account find(String id);
}
