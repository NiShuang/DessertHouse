package service;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface RechargeService {
	public boolean recharge(String id,String account_id,String password,double money);
	
	public List getPaymentRecord(String id);
}
