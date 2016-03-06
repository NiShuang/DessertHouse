package model;

import java.io.Serializable;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Store
 *
 */
@Entity
@Table(name="store")
public class Store implements Serializable {

	   
	@Id
	private int id;
	private String name;
	private String location;
	private String telephone;
	@OneToMany(mappedBy="store", cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE}, fetch = FetchType.EAGER)
	@OrderBy(value="id ASC")
	private Set<Clerk> clerks=new HashSet<Clerk>();
	@OneToMany(mappedBy="store", cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE}, fetch = FetchType.EAGER)
	@OrderBy(value="id ASC")
	private Set<PlanItem> planItems=new HashSet<PlanItem>();
	@OneToMany(mappedBy="store", cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE}, fetch = FetchType.EAGER)
	@OrderBy(value="id ASC")
	private Set<Reserve> reserves=new HashSet<Reserve>();
	@OneToMany(mappedBy="store", cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE}, fetch = FetchType.EAGER)
	@OrderBy(value="id ASC")
	private Set<ConsumeRecord> consumeRecords=new HashSet<ConsumeRecord>();
	private static final long serialVersionUID = 1L;

	public Store() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}   
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}   
	

	public Set<Clerk> getClerks(){
	return clerks;
	}
	public void setClerks(Set<Clerk> clerks){
		this.clerks=clerks;
		}

	public void addClerk(Clerk c){
		if(! this.clerks.contains(c)){
		this.clerks.add(c);
		c.setStore(this);
		}
	}

	public void removeClerk(Clerk c){
		c.setStore(null);
		this.clerks.remove(c);
		}
	
	public Set<PlanItem> getPlanItems(){
	return planItems;
	}
	public void setPlanItems(Set<PlanItem> planItems){
		this.planItems=planItems;
		}

	public void addPlanItem(PlanItem p){
		if(! this.planItems.contains(p)){
		this.planItems.add(p);
		p.setStore(this);
		}
	}

	public void removePlanItem(PlanItem p){
		p.setStore(null);
		this.planItems.remove(p);
		}

	public Set<Reserve> getReserves(){
	return reserves;
	}
	public void setReserves(Set<Reserve> reserves){
		this.reserves=reserves;
		}

	public void addReserve(Reserve r){
		if(! this.reserves.contains(r)){
		this.reserves.add(r);
		r.setStore(this);
		}
	}

	public void removeReserve(Reserve r){
		r.setStore(null);
		this.reserves.remove(r);
		}

	public Set<ConsumeRecord> getConsumeRecords(){
	return consumeRecords;
	}
	public void setConsumeRecords(Set<ConsumeRecord> consumeRecords){
		this.consumeRecords=consumeRecords;
		}

	public void addConsumeRecord(ConsumeRecord r){
		if(! this.consumeRecords.contains(r)){
		this.consumeRecords.add(r);
		r.setStore(this);
		}
	}

	public void removeConsumeRecord(ConsumeRecord r){
		r.setStore(null);
		this.consumeRecords.remove(r);
		}

}
