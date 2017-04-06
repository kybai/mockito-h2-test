package com.nine.mockitotest.service;

import com.nine.mockitotest.entity.Department;

public interface IDepartmentService {
	
	public Department findById(Long id);
	
	public void test(Long id);
}
