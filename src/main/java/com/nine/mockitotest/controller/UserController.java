package com.nine.mockitotest.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nine.mockitotest.entity.User;
import com.nine.mockitotest.service.IDepartmentService;
import com.nine.mockitotest.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IDepartmentService departmentService;

	/**
	 * 方法仅用于测试参考
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam(name="userName", required = true) String userName,
			@RequestParam(name="password", required = true) String password, Model model) {
		User user = userService.login(userName, password);
		model.addAttribute("user", user);
		if(user.getDepartmentId() != null)
			model.addAttribute("department", departmentService.findById(user.getDepartmentId()));
		return "index";
	}
	
	/**
	 * 方法仅用于测试参考
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public Long save(@RequestBody User user) {
		user = userService.save(user);
		return user.getId() == null ? -1 : user.getId();
	}
	
	/**
	 * 方法仅用于测试参考
	 */
	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> detail(@PathVariable Long id) {
		return userService.detail(id);
	}
	
}
