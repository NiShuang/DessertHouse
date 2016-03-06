package model;

import java.io.Serializable;
import java.lang.String;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: PaymentRecord
 *
 */
@Entity
@Table(name="payment_record")
public class PaymentRecord implements Serializable {

	   
	@Id
	private int id;
	private String member_id;
	private double charge;
	private Timestamp create_time;
	private static final long serialVersionUID = 1L;

	public PaymentRecord() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getMember_id() {
		return this.member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}   
	public double getCharge() {
		return this.charge;
	}

	public void setCharge(double charge) {
		this.charge = charge;
	}
	public Timestamp getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}   

   
}
