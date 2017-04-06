package com.nine.mockitotest.service;

import java.util.Map;

import com.nine.mockitotest.entity.User;

public interface IUserService {
	
	public User login(String userName, String password);
	
	public User save(User user);
	
	public Map<String, Object> detail(Long id);
	
}
