package model;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Clerk
 *
 */
@Entity
@Table(name="clerk")
public class Clerk implements Serializable {

	   
	@Id

	private String id;
	private String name;
	private String telephone;
	@ManyToOne(optional=true)
	@JoinColumn(name="store_id")
	private Store store;
	
	private static final long serialVersionUID = 1L;

	public Clerk() {
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

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
   
}
