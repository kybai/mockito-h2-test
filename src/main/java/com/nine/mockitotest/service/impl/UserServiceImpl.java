package com.nine.mockitotest.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nine.mockitotest.entity.Department;
import com.nine.mockitotest.entity.User;
import com.nine.mockitotest.repository.UserRepository;
import com.nine.mockitotest.service.IDepartmentService;
import com.nine.mockitotest.service.IUserService;
import com.nine.mockitotest.util.DeptUtil;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private IDepartmentService departmentService;

	@Override
	public User login(String userName, String password) {
		return userRepository.findByUserNameAndPassword(userName, password);
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public Map<String, Object> detail(Long id) {
		Map<String, Object> map = new HashMap<>();
		User user = userRepository.findOne(id);
		map.put("user", user);
		if(user != null && user.getDepartmentId() != null) {
			Department department = departmentService.findById(user.getDepartmentId());
			departmentService.test(id);//TODO仅为了测试void返回值
			department.setDescription(DeptUtil.countDeptNo(department.getId()).toString());
			map.put("department", department);
		}
		return map;
	}

}
