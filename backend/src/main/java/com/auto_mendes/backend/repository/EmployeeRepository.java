package com.auto_mendes.backend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.auto_mendes.backend.dto.response.EmployeeResponseDTO;
import com.auto_mendes.backend.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
	@Query(value = "SELECT e.id, e.name, e.email, e.matriculation, e.phone, e.birth_date, s.commission FROM employee_tb AS e LEFT JOIN saler_tb AS s ON e.id = s.id;", nativeQuery = true)
	Page<EmployeeResponseDTO> listEmployee(Pageable pageable);
}