package com.nine.mockitotest.controller;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import static com.jayway.jsonassert.JsonAssert.with;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import com.alibaba.fastjson.JSONObject;
import com.nine.mockitotest.entity.User;
import com.nine.mockitotest.service.IDepartmentService;
import com.nine.mockitotest.service.IUserService;
import com.nine.mockitotest.util.DefinedData;

//@RunWith(SpringRunner.class)
//@SpringBootTest
@PowerMockIgnore({ "javax.management.*" })
@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(SpringRunner.class)
public class UserControllerTest {

	@Mock
	private IUserService userService;

	@Mock
	private IDepartmentService departmentService;

	@InjectMocks
	private UserController userController;

	private MockMvc mockMvc;
	
//	@Autowired
//	WebApplicationContext wac;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
		mockMvc = standaloneSetup(userController).build();// 只启动我们测试需要的controller
//		mockMvc = webAppContextSetup(wac).build();// 加载所有,如测试生成pdf/excel之类情况
	}

	@Test
	public void loginTest() throws Exception {
		when(userService.login("aaa", "111")).thenReturn(DefinedData.setUser());
		when(departmentService.findById(1L)).thenReturn(DefinedData.setDepartment());
		MvcResult result = mockMvc.perform(post("/user/login")
				.param("userName", "aaa")
				.param("password", "111")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(view().name("index"))
		.andExpect(model().attributeExists("user"))
		.andExpect(model().attributeExists("department"))
//		.andDo(print())	//使用它可在控制台查看打印数据
		.andReturn();
		
		String json = JSONObject.toJSONString(result.getModelAndView().getModel().get("user"));
		with(json).assertEquals("$.id", 1);
	}

	@Test
	public void saveTest() throws Exception {
		User user = DefinedData.setUser();
		/* 此处save(user)中因转换成String,后被转成对象,mock认为不是同一对象,会返回null,所以使用any() */
		when(userService.save(anyObject())).thenReturn(user);
		MvcResult result = mockMvc.perform(post("/user/save")
				.content(JSONObject.toJSONString(user))	// 对应@RequestBody注解
//				.flashAttr("", "")						// 对应@ModelAttribute注解 或 无注解的对象
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().string("1"))
//		.andExpect(jsonPath("$.id").value(1)) 	//如果return的是user对象
		.andReturn();
		String json = result.getResponse().getContentAsString();
		with(json).assertEquals("$", 1);
//		with(json).assertEquals("$.id", 1);		//如果return的是user对象
	}
}
