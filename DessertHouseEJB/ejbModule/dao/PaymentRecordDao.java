package dao;

import java.util.List;

import javax.ejb.Remote;

import model.PaymentRecord;

@Remote
public interface PaymentRecordDao {

	public List findRecordByMember(String memberId);
	
	public void save(PaymentRecord paymentRecord);
}
