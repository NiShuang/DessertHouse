package service;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface OrderService {
	public List getConsumeRecord(String id);
}
