package model;

import java.io.Serializable;
import java.lang.String;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: ConsumeRecord
 *
 */
@Entity
@Table(name="consume_record")
public class ConsumeRecord implements Serializable {

	   
	@Id
	private int id;
	private String member;
	private String clerk;
	@ManyToOne(optional=true)
	@JoinColumn(name="store_id")
	private Store store;
	@ManyToOne(optional=true)
	@JoinColumn(name="commodity_id")
	private Commodity commodity;
	private double price;
	private int quantity;
	private double discount;
	private Timestamp create_time;	
	private static final long serialVersionUID = 1L;

	public ConsumeRecord() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getMember() {
		return this.member;
	}

	public void setMember(String member) {
		this.member = member;
	}   
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	public Commodity getCommodity() {
		return commodity;
	}
	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}
	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}   
	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}   
	
	public Timestamp getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}
	public String getClerk() {
		return clerk;
	}
	public void setClerk(String clerk) {
		this.clerk = clerk;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
   
}
