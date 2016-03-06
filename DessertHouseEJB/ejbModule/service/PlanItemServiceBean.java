package service;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import dao.CommodityDao;
import dao.PlanItemDao;
import dao.StoreDao;
import model.Commodity;
import model.PlanItem;
import model.Store;

/**
 * Session Bean implementation class PlanItemServiceBean
 */
@Stateless
//@LocalBean
public class PlanItemServiceBean implements PlanItemService {

	@EJB PlanItemDao planItemDao;
	@EJB StoreDao storeDao;
	@EJB CommodityDao commodityDao;
    public PlanItemServiceBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void add(int store_id,int commodity_id ,Date date,double price,int quantity) {
		// TODO Auto-generated method stub
		PlanItem planItem = new PlanItem();
		Store store = storeDao.find(store_id);
		Commodity commodity = commodityDao.find(commodity_id);
		planItem.setDate(date);
		planItem.setPrice(price);
		planItem.setQuantity(quantity);
		planItem.setSold(0);
		planItem.setReserve(0);
		planItem.setSchedule(0);
		planItem.setState(0);
//		store.addPlanItem(planItem);
//		commodity.addPlanItem(planItem);
		planItem.setStore(store);
		planItem.setCommodity(commodity);
		planItemDao.save(planItem);
//		commodityDao.updateById(commodity);
//		storeDao.updateById(store);

//		planItemDao.updateById(planItem);
	}

	@Override
	public void remove(int id) {
		// TODO Auto-generated method stub
		PlanItem plan = planItemDao.find(id);
		Store store = plan.getStore();
		store.removePlanItem(plan);
		storeDao.updateById(store);
		Commodity commodity = plan.getCommodity();
		commodity.removePlanItem(plan);
		commodityDao.updateById(commodity);
		planItemDao.remove(id);
	}

	@Override
	public PlanItem find(int id) {
		// TODO Auto-generated method stub
		return planItemDao.find(id);
	}

	@Override
	public void update(int id,double price,int quantity) {
		PlanItem planItem = planItemDao.find(id);
		planItem.setPrice(price);
		planItem.setQuantity(quantity);
		planItemDao.updateById(planItem);
	}

	@Override
	public List findByStore(int store) {
		// TODO Auto-generated method stub
		return planItemDao.findByStore(store);
	}

	@Override
	public void reserve(int id, int reserve) {
		// TODO Auto-generated method stub
		PlanItem planItem = planItemDao.find(id);
		planItem.setReserve(planItem.getReserve()+reserve);
		planItem.setSchedule(planItem.getSchedule()+reserve);
		planItemDao.updateById(planItem);
	}
	
	@Override
	public void sell(int id, int sold) {
		// TODO Auto-generated method stub
		PlanItem planItem = planItemDao.find(id);
		planItem.setSold(planItem.getSold()+sold);
		planItemDao.updateById(planItem);
	}

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return planItemDao.findAll();
	}

	@Override
	public void approve(int store, Date date) {
		// TODO Auto-generated method stub
		Store myStore = storeDao.find(store);
		Set<PlanItem> planItems = myStore.getPlanItems();
		for (PlanItem p: planItems) {
			if(p.getDate().equals(date)&&p.getState()!=0){
				p.setState(2);
				planItemDao.updateById(p);
			}	
		}
//		myStore.setPlanItems(planItems);
//		storeDao.updateById(myStore);
		
	}

	@Override
	public void setApprove(int id, int result) {
		// TODO Auto-generated method stub
		PlanItem planItem = planItemDao.find(id);
		planItem.setState(result);
		planItemDao.updateById(planItem);
	}

	@Override
	public void submit(int store, Date date) {
		// TODO Auto-generated method stub
		Store myStore = storeDao.find(store);
		Set<PlanItem> planItems = myStore.getPlanItems();
		for (PlanItem p: planItems) {
			if(p.getDate().equals(date)&&p.getState()==0||p.getState()==3){
				p.setState(1);
				planItemDao.updateById(p);
			}	
		}
//		myStore.setPlanItems(planItems);
//		storeDao.updateById(myStore);
		
	}

	@Override
	public List marketStatistics(int store) {
		// TODO Auto-generated method stub
		return planItemDao.marketStatictis(store);
	}

	@Override
	public String getHot(int store) {
		// TODO Auto-generated method stub
		List result = planItemDao.getHot(store);
		String hot = "";
		if(result!=null&&result.size()!=0){
			hot = String.valueOf(result.get(0));
		}
		return hot;
	}

}
