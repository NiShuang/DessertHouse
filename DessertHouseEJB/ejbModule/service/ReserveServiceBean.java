package service;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import dao.CommodityDao;
import dao.ConsumeRecordDao;
import dao.MemberDao;
import dao.PlanItemDao;
import dao.ReserveDao;
import dao.StoreDao;
import model.Commodity;
import model.ConsumeRecord;
import model.Member;
import model.PlanItem;
import model.Reserve;
import model.Store;

/**
 * Session Bean implementation class ReserveServiceBean
 */
@Stateless
//@LocalBean
public class ReserveServiceBean implements ReserveService {
	@EJB PlanItemDao planItemDao;
	@EJB PlanItemService planItemService;
	@EJB ConsumeRecordDao consumeRecordDao;
	@EJB ReserveDao reserveDao;
	@EJB StoreDao storeDao;
	@EJB CommodityDao commodityDao;
	@EJB MemberDao memberDao;
	@EJB MemberService memberService;
    public ReserveServiceBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean add(String member_id,int planItem_id,int quantity,double discount) {
		// TODO Auto-generated method stub
		Reserve reserve = new Reserve();
		PlanItem planItem = planItemDao.find(planItem_id);
		double total_price = planItem.getPrice()*quantity*discount;
//		Store store = storeDao.find(store_id);
//		Commodity commodity = commodityDao.find(commodity_id);
		Member member = memberDao.find(member_id); 
		if(member.getBalance()<total_price)
			return false;
		else{
			reserve.setMember(member_id);
			reserve.setIsPay(0);
			reserve.setDate(planItem.getDate());
			reserve.setPrice(planItem.getPrice());
			reserve.setQuantity(quantity);
			reserve.setPlan_id(planItem_id);
			reserve.setDiscount(discount);
			reserve.setCreate_time(new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()));
			reserve.setStore(planItem.getStore());
			reserve.setCommodity(planItem.getCommodity());
			reserveDao.save(reserve);
			planItemService.reserve(planItem_id, quantity);
			memberService.pay(member_id, total_price);
			return true;
		}
		
	}

	@Override
	public void cancel(int id) {
		// TODO Auto-generated method stub
		Reserve reserve = reserveDao.find(id);
		int plan_id = reserve.getPlan_id();
		String  member_id = reserve.getMember();
		double total_price = reserve.getPrice()*reserve.getQuantity()*reserve.getDiscount();
		PlanItem plan = planItemDao.find(plan_id);
		plan.setReserve(plan.getReserve()-reserve.getQuantity());
		plan.setSchedule(plan.getSchedule()-reserve.getQuantity());
		planItemDao.updateById(plan);
		reserve.setIsPay(2);
		memberService.returnPay(member_id,total_price);
		reserveDao.updateById(reserve);
	}

	@Override
	public Reserve find(int id) {
		// TODO Auto-generated method stub
		return reserveDao.find(id);
	}

	@Override
	public List findByMember(String member) {
		// TODO Auto-generated method stub
		return reserveDao.findByMember(member);
	}

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return reserveDao.findAll();
	}
	
	public List findToPayByMember(String member){
		return reserveDao.findToPayByMember(member);
	}

	@Override
	public void sellReserve(int id,String clerk) {
		// TODO Auto-generated method stub
		Reserve reserve = reserveDao.find(id);
		String member_id = reserve.getMember();
		int planItem_id = reserve.getPlan_id();
		int quantity = reserve.getQuantity();
		double discount = reserve.getDiscount();
		ConsumeRecord consumeRecord = new ConsumeRecord();
		PlanItem planItem = planItemDao.find(planItem_id);
		consumeRecord.setMember(member_id);
		consumeRecord.setClerk(clerk);
		consumeRecord.setPrice(planItem.getPrice());
		consumeRecord.setQuantity(quantity);
		consumeRecord.setCreate_time(new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()));
		consumeRecord.setStore(planItem.getStore());
		consumeRecord.setDiscount(discount);
		consumeRecord.setCommodity(planItem.getCommodity());
		consumeRecordDao.save(consumeRecord);
		planItem.setSchedule(planItem.getSchedule()-quantity);
		planItemDao.updateById(planItem);
		planItemService.sell(planItem_id, quantity);
		reserve.setIsPay(1);
		reserveDao.updateById(reserve);
	}

}
