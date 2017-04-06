package com.nine.mockitotest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nine.mockitotest.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public User findByUserNameAndPassword(String userName, String password);
}
