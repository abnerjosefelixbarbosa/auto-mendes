package com.auto_mendes.backend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.auto_mendes.backend.dto.EmployeeResponseListDTO;
import com.auto_mendes.backend.model.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, String> {
	@Query(value = "SELECT e.id, e.name, e.email, e.matriculation, e.phone, e.birth_date, e.employee_type, s.commission "
			+ "FROM employee_tb e " + "LEFT JOIN saler_tb s ON e.id = s.id", nativeQuery = true)
	Page<EmployeeResponseListDTO> listEmployees(Pageable pageable);

	boolean existsByEmailOrMatriculationOrPhone(String email, String matriculation, String phone);
}