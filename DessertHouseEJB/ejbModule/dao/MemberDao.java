package dao;

import java.util.List;

import javax.ejb.Remote;

import model.Member;


@Remote
public interface MemberDao {
	
	public Member find(String id);
	
	public void save(Member member);
	
	public void updateById(Member member);
	
	public int getMaxId();
	
	public List findAll();
	
	public List sexStatistics();
	
	public List placeStatistics();
	
	public List ageStatistics();
	
	public List consumeStatistics();
	
	public List cardStatistics();
}
