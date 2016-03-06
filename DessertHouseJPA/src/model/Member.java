package model;

import java.io.Serializable;
import java.lang.String;
import java.sql.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Member
 *
 */
@Entity
@Table(name="member")
public class Member implements Serializable {

	   
	@Id
	private String id;
	private String name;
	private int sex;
	private Date birthday;
	private String place;
	private double expense;
	private double balance;
	private double charge;
	private int level;
	private int is_active;
	private int point;
	private java.util.Date activate_time;
	private java.util.Date pause_time;
	private Date create_time;
	////create_time
	private static final long serialVersionUID = 1L;

	public Member() {
		super();
	}   
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}   

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	

	
	public String getPlace() {
		return place;
	}
	
	public void setPlace(String place) {
		this.place = place;
	}
	
	public double getExpense() {
		return expense;
	}
	
	public void setExpense(double expense) {
		this.expense = expense;
	}
	
	public double getBalance() {
		return this.balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}   
	public double getCharge() {
		return this.charge;
	}

	public void setCharge(double charge) {
		this.charge = charge;
	}   
	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}   
	public int getIs_active() {
		return this.is_active;
	}

	public void setIs_active(int is_active) {
		this.is_active = is_active;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public java.util.Date getActivate_time() {
		return activate_time;
	}
	public void setActivate_time(java.util.Date activate_time) {
		this.activate_time = activate_time;
	}
	public java.util.Date getPause_time() {
		return pause_time;
	}
	public void setPause_time(java.util.Date pause_time) {
		this.pause_time = pause_time;
	}


   
}
