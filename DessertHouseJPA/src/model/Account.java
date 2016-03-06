package model;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Account
 *
 */
@Entity
@Table(name="account")
public class Account implements Serializable {

	   
	@Id
	private String id;
	private String password;
	private double balance;
	private static final long serialVersionUID = 1L;

	public Account() {
		super();
	}   
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}   
	public double getBalance() {
		return this.balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
   
}
