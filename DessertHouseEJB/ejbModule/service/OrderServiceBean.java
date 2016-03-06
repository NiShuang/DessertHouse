package service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import dao.ConsumeRecordDao;

/**
 * Session Bean implementation class OrderServiceBean
 */
@Stateless
@LocalBean
public class OrderServiceBean implements OrderService {
	@EJB ConsumeRecordDao consumeRecordDao;
    /**
     * Default constructor. 
     */
    public OrderServiceBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List getConsumeRecord(String id) {
		// TODO Auto-generated method stub
		return consumeRecordDao.findRecordByMember(id);
		
	}

}
