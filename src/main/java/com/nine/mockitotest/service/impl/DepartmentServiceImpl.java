package com.nine.mockitotest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nine.mockitotest.entity.Department;
import com.nine.mockitotest.repository.DepartmentRepository;
import com.nine.mockitotest.service.IDepartmentService;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public Department findById(Long id) {
		return departmentRepository.findOne(id);
	}

	@Override
	public void test(Long id) {
		id++;
	}

}
