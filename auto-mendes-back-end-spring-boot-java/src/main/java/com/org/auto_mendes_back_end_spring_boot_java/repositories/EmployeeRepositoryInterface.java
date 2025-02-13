package com.org.auto_mendes_back_end_spring_boot_java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.auto_mendes_back_end_spring_boot_java.entities.Employee;

@Repository
public interface EmployeeRepositoryInterface extends JpaRepository<Employee, String> {
	boolean existsByCpfOrEmailOrTelephoneOrMatriculation(String cpf, String email, String telephone,
			String matriculation);
}