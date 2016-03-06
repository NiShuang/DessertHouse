package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Plan
 *
 */
@Entity
@Table(name="plan")
public class Plan implements Serializable {

	   
	@Id
	private int id;
	private int store;
	private int week;
	private static final long serialVersionUID = 1L;

	public Plan() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public int getStore() {
		return this.store;
	}

	public void setStore(int store) {
		this.store = store;
	}   
	public int getWeek() {
		return this.week;
	}

	public void setWeek(int week) {
		this.week = week;
	}
   
}
