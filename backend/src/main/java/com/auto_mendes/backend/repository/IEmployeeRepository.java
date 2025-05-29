package com.auto_mendes.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auto_mendes.backend.model.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, String> {
	boolean existsByEmailOrMatriculationOrPhone(String email, String matriculation, String phone);
}