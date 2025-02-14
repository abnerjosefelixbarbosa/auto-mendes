package com.org.auto_mendes_back_end_spring_boot_java.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Employee;

@Repository
public interface EmployeeRepositoryInterface extends JpaRepository<Employee, String> {
	@Query(value = "SELECT e.id, e.name, e.cpf, e.email, e.telephone, e.salary, e.matriculation, s.commission FROM employees e LEFT JOIN salers s ON e.id = s.id", nativeQuery = true)
	Page<EmployeeResponseDTO> listEmployees(Pageable pageable);
	@Query(value = "SELECT e.id, e.name, e.cpf, e.email, e.telephone, e.salary, e.matriculation, s.commission FROM employees e LEFT JOIN salers s ON e.id = s.id", nativeQuery = true)
	Page<EmployeeResponseDTO> listEmployeesByMatriculation(Pageable pageable, String matriculation);
	boolean existsByCpfOrEmailOrTelephoneOrMatriculation(String cpf, String email, String telephone,
			String matriculation);
}