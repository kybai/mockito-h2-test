package com.nine.mockitotest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "department", schema = "public")
public class Department extends BaseEntity {
	
	private static final long serialVersionUID = 7151720344439940242L;

	private String name;
	private String description;

	@Column(name = "name")
	public String getName() {
		return name;
	}
	
	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
}
