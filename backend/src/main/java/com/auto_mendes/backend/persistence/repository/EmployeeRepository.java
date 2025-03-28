package com.auto_mendes.backend.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auto_mendes.backend.persistence.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
}