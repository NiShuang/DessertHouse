package model;

import java.io.Serializable;
import java.lang.String;
import java.sql.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: PlanItem
 *
 */
@Entity
@Table(name="plan_item")
public class PlanItem implements Serializable {

	   
	@Id
	private int id;
	@ManyToOne(optional=true)
	@JoinColumn(name="store_id")
	private Store store;
	@ManyToOne(optional=true)
	@JoinColumn(name="commodity_id")
	private Commodity commodity;
	private Date date;
	private double price;
	private int quantity;
	private int sold;
	private int reserve;
	private int schedule;
	private int state;
	private static final long serialVersionUID = 1L;

	public PlanItem() {
		super();
	}   
	public int getId() {
		return this.id;
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
	public int getSold() {
		return sold;
	}
	public void setSold(int sold) {
		this.sold = sold;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getReserve() {
		return reserve;
	}
	public void setReserve(int reserve) {
		this.reserve = reserve;
	}
	public int getSchedule() {
		return schedule;
	}
	public void setSchedule(int schedule) {
		this.schedule = schedule;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
}
