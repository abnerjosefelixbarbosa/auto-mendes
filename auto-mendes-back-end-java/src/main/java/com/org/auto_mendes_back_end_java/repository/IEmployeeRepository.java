package com.org.auto_mendes_back_end_java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.auto_mendes_back_end_java.entity.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, String> {
	boolean existsByCpfOrRgOrEmailOrContact(String cpf, String rg, String email, String contact);
}