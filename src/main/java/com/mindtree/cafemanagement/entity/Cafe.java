package com.mindtree.cafemanagement.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cafe {

	@Id
	private int id;
	private String name;

	@ManyToOne
	private Manager manager;

	public Cafe() {
		super();
	}

	public Cafe(int id, String name, Manager manager) {
		super();
		this.id = id;
		this.name = name;
		this.manager = manager;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

}
