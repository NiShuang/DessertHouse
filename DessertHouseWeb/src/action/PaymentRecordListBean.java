package action;

import java.io.Serializable;
import java.util.List;

import model.PaymentRecord;

public class PaymentRecordListBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private List paymentRecordList;

	
	public List getPaymentRecordList() {
		return paymentRecordList;
	}

	
	public void setPaymentRecordList(List paymentRecordList) {
		this.paymentRecordList = paymentRecordList;
	}
	
	
	public void setPaymentRecordList(PaymentRecord paymentRecord, int index) {
		paymentRecordList.set(index, paymentRecord);
		}
	
	public PaymentRecord getPaymentRecordList(int index) {
		return (PaymentRecord) paymentRecordList.get(index);
	}
}
