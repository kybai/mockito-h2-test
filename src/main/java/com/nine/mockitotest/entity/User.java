package com.nine.mockitotest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user", schema = "public")
public class User extends BaseEntity {

	private static final long serialVersionUID = 8111592204457751409L;

	private String userName;

	private String password;

	private Long departmentId;//使用弱关联

	@Column(name = "user_name")
	public String getUserName() {
		return userName;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	@Column(name = "department_id")
	public Long getDepartmentId() {
		return departmentId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

}
