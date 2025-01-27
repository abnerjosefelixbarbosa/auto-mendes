package com.org.auto_mendes_back_end_spring_boot_java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.auto_mendes_back_end_spring_boot_java.entities.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, String> {
	boolean existsByCpfOrEmailOrMatriculationOrContact(String cpf, String email, String matriculation, String contact);
	boolean existsByCpf(String cpf);
	boolean existsByEmail(String email);
	boolean existsByMatriculation(String matriculation);
	boolean existsByContact(String contact);
}