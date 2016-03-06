package model;

import java.io.Serializable;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Commodity
 *
 */
@Entity
@Table(name="commodity")
public class Commodity implements Serializable {

	   
	@Id
	private int id;
	private String name;
	@OneToMany(mappedBy="commodity", cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE}, fetch = FetchType.EAGER)
	@OrderBy(value="id ASC")
	private Set<PlanItem> planItems=new HashSet<PlanItem>();
	@OneToMany(mappedBy="commodity", cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE}, fetch = FetchType.EAGER)
	@OrderBy(value="id ASC")
	private Set<Reserve> reserves=new HashSet<Reserve>();
	@OneToMany(mappedBy="commodity", cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE}, fetch = FetchType.EAGER)
	@OrderBy(value="id ASC")
	private Set<ConsumeRecord> consumeRecords=new HashSet<ConsumeRecord>();
	private static final long serialVersionUID = 1L;

	public Commodity() {
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
	public Set<PlanItem> getPlanItems(){
	return planItems;
	}
	public void setPlanItems(Set<PlanItem> planItems){
		this.planItems=planItems;
		}

	public void addPlanItem(PlanItem p){
		if(! this.planItems.contains(p)){
		this.planItems.add(p);
		p.setCommodity(this);
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
		r.setCommodity(this);
		}
	}

	public void removeReserve(Reserve r){
		r.setCommodity(null);
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
		r.setCommodity(this);
		}
	}

	public void removeConsumeRecord(ConsumeRecord r){
		r.setCommodity(null);
		this.consumeRecords.remove(r);
		}
}
