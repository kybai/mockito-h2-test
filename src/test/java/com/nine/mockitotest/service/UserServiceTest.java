package com.nine.mockitotest.service;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.nine.mockitotest.entity.Department;
import com.nine.mockitotest.repository.UserRepository;
import com.nine.mockitotest.service.impl.UserServiceImpl;
import com.nine.mockitotest.util.DefinedData;
import com.nine.mockitotest.util.DeptUtil;

//@RunWith(SpringRunner.class)
//@SpringBootTest
@PowerMockIgnore({ "javax.management.*" })
@RunWith(PowerMockRunner.class)
@PrepareForTest({ DeptUtil.class })
public class UserServiceTest {

	@Mock
	private UserRepository userRepository;

	@Mock
	private IDepartmentService departmentService;

	@InjectMocks
	private IUserService userService = new UserServiceImpl();

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void detailTest() {
		when(userRepository.findOne(1L)).thenReturn(DefinedData.setUser()).thenReturn(null);
		when(departmentService.findById(1L)).thenReturn(DefinedData.setDepartment());
		Map<String, Object> map1 = userService.detail(1L);
		doNothing().when(departmentService).test(1L);
		mockStatic(DeptUtil.class);
		when(DeptUtil.countDeptNo(1L)).thenReturn(2L);
		Assert.assertTrue(map1.size() == 2);
		Assert.assertTrue(((Department) map1.get("department")).getDescription().equals("2"));
		Map<String, Object> map2 = userService.detail(1L);
		Assert.assertTrue(map2.size() == 1);
	}

}
