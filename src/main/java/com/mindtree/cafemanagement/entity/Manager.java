package com.mindtree.cafemanagement.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Manager {
    
	@Id
	private int id;
	private String name;
	@OneToMany(mappedBy = "manager")
	private List<Cafe> cafes;

	public Manager() {
		super();
	}

	public Manager(int id, String name, List<Cafe> cafes) {
		super();
		this.id = id;
		this.name = name;
		this.cafes = cafes;
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

	public List<Cafe> getCafes() {
		return cafes;
	}

	public void setCafes(List<Cafe> cafes) {
		this.cafes = cafes;
	}

}
