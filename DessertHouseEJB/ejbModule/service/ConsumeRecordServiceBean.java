package service;

import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import dao.CommodityDao;
import dao.ConsumeRecordDao;
import dao.MemberDao;
import dao.PlanItemDao;
import dao.StoreDao;
import model.ConsumeRecord;
import model.Member;
import model.PlanItem;

/**
 * Session Bean implementation class ConsumeRecordSeviceBean
 */
@Stateless
//@LocalBean
public class ConsumeRecordServiceBean implements ConsumeRecordService {
	@EJB PlanItemDao planItemDao;
	@EJB ConsumeRecordDao consumeRecordDao;
	@EJB PlanItemService planItemService;
	@EJB StoreDao storeDao;
	@EJB CommodityDao commodityDao;
	@EJB MemberDao memberDao;
	@EJB MemberService memberService;
    /**
     * Default constructor. 
     */
    public ConsumeRecordServiceBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean add(String member_id, String clerk_id, int planItem_id, int quantity,double discount) {
		// TODO Auto-generated method stub
		ConsumeRecord consumeRecord = new ConsumeRecord();
		PlanItem planItem = planItemDao.find(planItem_id);
		double total_price = planItem.getPrice()*quantity*discount;
		if(!member_id.equals("0000000")){
			Member member = memberDao.find(member_id); 
			if(member.getBalance()<total_price)
				return false;
			else{
				consumeRecord.setMember(member_id);
				consumeRecord.setClerk(clerk_id);
				consumeRecord.setPrice(planItem.getPrice());
				consumeRecord.setQuantity(quantity);
				consumeRecord.setDiscount(discount);
				consumeRecord.setCreate_time(new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()));
				consumeRecord.setStore(planItem.getStore());
				consumeRecord.setCommodity(planItem.getCommodity());
				consumeRecordDao.save(consumeRecord);
					
				planItemService.sell(planItem_id, quantity);
				memberService.pay(member_id, total_price);
				return true;
			}
		}
	//	Store store = storeDao.find(store_id);
	//	Commodity commodity = commodityDao.find(commodity_id);
		consumeRecord.setMember(member_id);
		consumeRecord.setClerk(clerk_id);
		consumeRecord.setPrice(planItem.getPrice());
		consumeRecord.setQuantity(quantity);
		consumeRecord.setDiscount(discount);
		consumeRecord.setCreate_time(new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()));
		consumeRecord.setStore(planItem.getStore());
		consumeRecord.setCommodity(planItem.getCommodity());
		consumeRecordDao.save(consumeRecord);
			
		planItemService.sell(planItem_id, quantity);
		return true;
		
	}

	@Override
	public List findByMember(String member) {
		// TODO Auto-generated method stub
		return consumeRecordDao.findRecordByMember(member);
	}

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return consumeRecordDao.findAll();
	}

}
