package com.mindtree.cafemanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mindtree.cafemanagement.entity.Manager;

public class CafeDto {

	private int id;
	private String name;
	@JsonIgnoreProperties("cafes")
	private Manager manager;

	public CafeDto() {
		super();
	}

	public CafeDto(int id, String name, Manager manager) {
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
