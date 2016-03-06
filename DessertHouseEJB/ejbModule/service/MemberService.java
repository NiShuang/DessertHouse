package service;

import java.sql.Date;
import java.util.List;

import javax.ejb.Remote;

import model.Member;

@Remote
public interface MemberService {

	public String register(String name,String password,int sex,Date birthday ,String place);
	
	public void modify(String id,String name,int sex, Date birthday,String place);
	
	public void modifyPassword(String id,String oldPassword,String newPassword);
	
	public Member find(String id);
	
	public String getNewId();
	
	public void activate(String id);
	
	public void updateLevel(String id);
	
	public int getLevel(double charge);
	
	public void pay(String id,double money);
	
	public void returnPay(String id,double money);
	
	public List sexStatistics();
	
	public List placeStatistics();
	
	public List ageStatistics();
	
	public List consumeStatistics();
	
	public List cardStatistics();

	public int getPoint(String id,double money); 
	
	public void exchange(String id,int point);
	
	public void setState(String id,int state);
	
	public void stopMember(String id);
	
	public double getDiscount(String id);
	
	public int timingJob();

	
}
