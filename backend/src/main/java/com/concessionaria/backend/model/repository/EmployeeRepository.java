package com.concessionaria.backend.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.concessionaria.backend.model.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String>, JpaSpecificationExecutor<Employee> {
	boolean existsByNameOrMatriculationOrEmailOrPhoneOrCpf(String name, String matriculation, String email,
			String phone, String cpf);

	Optional<Employee> findByMatriculation(String matriculation);
}
