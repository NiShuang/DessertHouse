package model;

import java.io.Serializable;
import java.lang.String;
import java.sql.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@Table(name="user")
public class User implements Serializable {

	   
	@Id
	private String id;
	private String password;
	private int type;
	private static final long serialVersionUID = 1L;

	public User() {
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
	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

   
}
