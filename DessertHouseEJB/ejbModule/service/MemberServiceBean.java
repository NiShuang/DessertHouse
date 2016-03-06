package service;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import dao.MemberDao;
import dao.PaymentRecordDao;
import model.Member;
import model.PaymentRecord;


/**
 * Session Bean implementation class MemberServiceBean
 */
@Stateless
//@LocalBean
public class MemberServiceBean implements MemberService {

    /**
     * Default constructor. 
     */
    public MemberServiceBean() {
        // TODO Auto-generated constructor stub
    }
    @EJB MemberDao memberDao;
    @EJB PaymentRecordDao paymentRecordDao;
    @EJB UserService uservice;
	@Override
	public String register(String name, String password,int sex,Date birthday,String place) {
		// TODO Auto-generated method stub
		Member member = new Member();
		String id = getNewId();
		Calendar.getInstance();
		member.setId(id);
		member.setName(name);
		member.setSex(sex);
		member.setBirthday(birthday);
		member.setPlace(place);
		member.setExpense(0);
		member.setBalance(0);
		member.setCharge(0);
		member.setLevel(1);
		member.setIs_active(0);
		member.setPoint(0);
		member.setCreate_time(new Date(System.currentTimeMillis()));
		memberDao.save(member);
		
		uservice.register(id, password, 1);
		return id;
	}
	@Override
	public String getNewId() {
		// TODO Auto-generated method stub
		int maxId = memberDao.getMaxId();
		maxId++;
		String newId = String.valueOf(maxId);
		int count = 1;
		while(maxId/10!=0){
			count++;
			maxId/=10;
		}
		if(count<7){
			 for(int i = 0;i<7-count;i++){
				 newId = "0"+newId;
			 }
		}
		return newId;
	}
	@Override
	public void activate(String id) {
		// TODO Auto-generated method stub
		Member member = memberDao.find(id);
		member.setIs_active(1);
		memberDao.updateById(member);
	}

	@Override
	public void updateLevel(String id) {
		// TODO Auto-generated method stub
		Member member = memberDao.find(id);
		double charge = member.getCharge();
		member.setLevel(getLevel(charge));
		memberDao.updateById(member);
	}
	@Override
	public int getLevel(double charge) {
		// TODO Auto-generated method stub
		if(charge<500)
			return 1;
		else if(charge>=500&&charge<1000)
			return 2;
		else if(charge>=1000&&charge<5000)
			return 3;
		else if(charge>=5000&&charge<10000)
			return 4;
		else
			return 5;
	}

	@Override
	public Member find(String id) {
		// TODO Auto-generated method stub
		return memberDao.find(id);
	}
	@Override
	public void modify(String id, String name,int sex, Date birthday, String place) {
		// TODO Auto-generated method stub
		Member member = memberDao.find(id);
		member.setName(name);
		member.setSex(sex);
		member.setBirthday(birthday);
		member.setPlace(place);
		memberDao.updateById(member);
	}
	@Override
	public void modifyPassword(String id, String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void pay(String id, double money) {
		// TODO Auto-generated method stub
		Member member = memberDao.find(id);
		member.setBalance((double)(Math.round((member.getBalance()-money)*100))/100);
		member.setExpense((double)(Math.round((member.getExpense()+money)*100))/100);
		memberDao.updateById(member);
	}
	@Override
	public List sexStatistics() {
		// TODO Auto-generated method stub
		return memberDao.sexStatistics();
	}
	@Override
	public List placeStatistics() {
		// TODO Auto-generated method stub
		return memberDao.placeStatistics();
	}
	
	@Override
	public List ageStatistics() {
		// TODO Auto-generated method stub
		return memberDao.ageStatistics();
	}
	
	@Override
	public List consumeStatistics() {
		// TODO Auto-generated method stub
		return memberDao.consumeStatistics();
	}
	
	@Override
	public List cardStatistics() {
		// TODO Auto-generated method stub
		return memberDao.cardStatistics();
	}
	@Override
	public void returnPay(String id, double money) {
		// TODO Auto-generated method stub
		Member member = memberDao.find(id);
		member.setBalance(member.getBalance()+money);
		member.setExpense(member.getExpense()-money);
		memberDao.updateById(member);
	}
	@Override
	public int getPoint(String id, double money) {
		// TODO Auto-generated method stub
		int point = 0;
		point = (((int)money)/10);
		Member member = memberDao.find(id);
		member.setPoint(member.getPoint()+point);
		memberDao.updateById(member);
		return point;
	}
	@Override
	public void exchange(String id, int point) {
		// TODO Auto-generated method stub
		Member member = memberDao.find(id);
		member.setPoint(member.getPoint()-point);
		member.setBalance(member.getBalance()+point);
		memberDao.updateById(member);
	}
	@Override
	public void setState(String id, int state) {
		// TODO Auto-generated method stub
		Member member = memberDao.find(id);
		member.setIs_active(state);
		memberDao.updateById(member);
	}
	@Override
	public double getDiscount(String id) {
		// TODO Auto-generated method stub
		double discount = 1.0;
		Member member = memberDao.find(id);
		int level = member.getLevel();
		if(level==2)
			discount = 0.95;
		else if(level==3)
			discount = 0.90;
		else if(level==4)
			discount = 0.85;
		else if(level==5)
			discount = 0.8;
		return discount;
	}

	@Override
	public void stopMember(String id) {
		// TODO Auto-generated method stub
		Member member = memberDao.find(id);
		if(member.getIs_active()!=3){
			member.setIs_active(3);
			member.setPause_time(new java.util.Date());
		}
		memberDao.updateById(member);
	}

	@Override
	public int timingJob() {
		// TODO Auto-generated method stub
		List list = memberDao.findAll();
		for(int i = 0;i<list.size();i++){
			Member member = (Member)list.get(i);
			int state = member.getIs_active();
			if(state==1&&member.getActivate_time()!=null){
				java.util.Date activate_time = member.getActivate_time();
				java.util.Date now = new java.util.Date();
				if((now.getTime() - activate_time.getTime()>=(1000 * 60 * 60 * 24 * 365))&&member.getBalance()<=0){
					member.setIs_active(2);
					member.setPause_time(now);
					memberDao.updateById(member);
				}
			}
			else if(state==2||state==0&&member.getPause_time()!=null){
				java.util.Date pause_time = member.getPause_time();
				java.util.Date now = new java.util.Date();
				if((now.getTime() - pause_time.getTime()>=(1000 * 60 * 60 * 24 * 365))&&member.getBalance()<=0){
					member.setIs_active(3);
					memberDao.updateById(member);
				}
			}
		}
		return 0;
	}

}
