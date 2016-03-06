package service;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import dao.PaymentRecordDao;
import helper.MD5Helper;
import model.Account;
import model.Member;
import model.PaymentRecord;
import dao.AccountDao;
import dao.ConsumeRecordDao;
import dao.MemberDao;


/**
 * Session Bean implementation class RechargeServiceBean
 */
@Stateless
//@LocalBean
public class RechargeServiceBean implements RechargeService {
	@EJB PaymentRecordDao paymentRecordDao;
	@EJB AccountDao accountDao;
	@EJB MemberDao memberDao;
	@EJB ConsumeRecordDao consumeRecordDao;
	@EJB MemberService memberService;

    public RechargeServiceBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean recharge(String id, String account_id, String password, double money) {
		// TODO Auto-generated method stub
		Member member = memberDao.find(id);
		if(member==null)
			return false;
		else{
			Account account = accountDao.find(account_id);
			if(account ==null)
				return false;
			else if(account.getPassword().equals(MD5Helper.getMd5(password))){
				member.setBalance(member.getBalance()+money);
				member.setCharge(member.getCharge()+money);
				if(money>=200){
					int state = member.getIs_active();
					if(state!=1){
						member.setIs_active(1);
						member.setActivate_time(new java.util.Date());
					}
				}
				memberDao.updateById(member);
				
				PaymentRecord paymentRecord = new PaymentRecord();
				paymentRecord.setMember_id(id);
				paymentRecord.setCharge(money);
				paymentRecord.setCreate_time(new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()));
				paymentRecordDao.save(paymentRecord);
				
			    account.setBalance(account.getBalance()-money);
			    accountDao.updateById(account);
			    memberService.updateLevel(id);
			    return true;
			}
			else 
				return false;
		}
	}
	
	@Override
	public List getPaymentRecord(String id) {
		// TODO Auto-generated method stub
		return paymentRecordDao.findRecordByMember(id);
	}

}
