package com.nine.mockitotest.util;

import java.util.Date;

import com.nine.mockitotest.entity.Department;
import com.nine.mockitotest.entity.User;

public class DefinedData {

	public static User setUser() {
		User user = new User();
		user.setId(1L);
		user.setCreateTime(new Date());
		user.setDepartmentId(1L);
		user.setUserName("aaa");
		user.setPassword("111");
		return user;
	}

	public static Department setDepartment() {
		Department department = new Department();
		department.setId(1L);
		department.setDescription("test");
		department.setCreateTime(new Date());
		department.setName("管理部");
		return department;
	}
}
