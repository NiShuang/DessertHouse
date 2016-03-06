package model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Reserve
 *
 */
@Entity
@Table(name="reserve")
public class Reserve implements Serializable {

	@Id
	private int id;
	private String member;
	@ManyToOne(optional=true)
	@JoinColumn(name="store_id")
	private Store store;
	@ManyToOne(optional=true)
	@JoinColumn(name="commodity_id")
	private Commodity commodity;
	private Date date;
	private double price;
	private int quantity;
	private int isPay;
	private int plan_id;
	private double discount;
	private Timestamp create_time;

	private static final long serialVersionUID = 1L;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
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


	public Reserve() {
		super();
	}

	public String getMember() {
		return member;
	}

	public void setMember(String member) {
		this.member = member;
	}

	public int getIsPay() {
		return isPay;
	}

	public void setIsPay(int isPay) {
		this.isPay = isPay;
	}

	public int getPlan_id() {
		return plan_id;
	}

	public void setPlan_id(int plan_id) {
		this.plan_id = plan_id;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
   
}
