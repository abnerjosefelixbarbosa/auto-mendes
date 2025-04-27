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
	@Query(value = "SELECT new com.auto_mendes.backend.dto.response.EmployeeResponseDTO(e.id, e.name, e.email, e.matriculation, e.phone, e.birthDate, s.commission) FROM Employee e LEFT JOIN Saler s ON e.id = s.id")
	Page<EmployeeResponseDTO> listEmployee(Pageable pageable);
}