package com.nine.mockitotest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nine.mockitotest.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
