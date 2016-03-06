package action;

import java.io.Serializable;
import java.util.List;

import model.ConsumeRecord;

public class ConsumeRecordListBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private List consumeRecordList;

	
	public List getConsumeRecordList() {
		return consumeRecordList;
	}

	
	public void setConsumeRecordList(List consumeRecordList) {
		this.consumeRecordList = consumeRecordList;
	}
	
	
	public void setConsumeRecordList(ConsumeRecord consumeRecord, int index) {
		consumeRecordList.set(index, consumeRecord);
		}
	
	public ConsumeRecord getConsumeRecordList(int index) {
		return (ConsumeRecord) consumeRecordList.get(index);
	}
}
