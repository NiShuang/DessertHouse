package service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import dao.CommodityDao;
import dao.StoreDao;
import model.Commodity;

/**
 * Session Bean implementation class CommodityServiceBean
 */
@Stateless
//@LocalBean
public class CommodityServiceBean implements CommodityService {
	@EJB CommodityDao commodityDao;
    public CommodityServiceBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void add(String name) {
		// TODO Auto-generated method stub
		Commodity commodity = new Commodity();
		commodity.setName(name);
		commodityDao.save(commodity);
	}

	@Override
	public void remove(int id) {
		// TODO Auto-generated method stub
		commodityDao.remove(id);
	}

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return commodityDao.findAll();
	}

	@Override
	public Commodity find(int id) {
		// TODO Auto-generated method stub
		return commodityDao.find(id);
	}

	@Override
	public void update(int id, String name) {
		// TODO Auto-generated method stub
		Commodity commodity = commodityDao.find(id);
		commodity.setName(name);
		commodityDao.updateById(commodity);
	}

}
