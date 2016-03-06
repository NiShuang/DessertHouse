package dao;

import java.util.List;

import javax.ejb.Remote;

import model.ConsumeRecord;

@Remote
public interface ConsumeRecordDao {
	public List findRecordByMember(String memberId);
	
	public void save(ConsumeRecord consumeRecord);
	
	public List findAll();
}
