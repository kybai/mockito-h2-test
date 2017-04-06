package com.nine.mockitotest.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import com.nine.mockitotest.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(scripts = "classpath:db/db_init_user.sql")
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void findByUserNameAndPasswordTest() {
		User user = userRepository.findByUserNameAndPassword("bky", "111");
		Assert.assertTrue(user.getId() != null);
	}
}
