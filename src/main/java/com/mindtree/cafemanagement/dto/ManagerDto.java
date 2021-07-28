package com.mindtree.cafemanagement.dto;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mindtree.cafemanagement.entity.Cafe;

public class ManagerDto {

	private int id;
	private String name;
	@JsonIgnoreProperties("manager")
	private List<Cafe> cafes;

	public ManagerDto() {
		super();
	}

	public ManagerDto(int id, String name, List<Cafe> cafes) {
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
