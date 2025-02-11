package com.org.auto_mendes_back_end_spring_boot_java.repositories;

import java.math.BigDecimal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Employee;

@Repository
public interface EmployeeRepositoryInterface extends JpaRepository<Employee, String> {
	@Query(value = "SELECT e.id, e.name, e.cpf, e.email, e.telephone, e.salary, e.matriculation, e.commission FROM employees e", countQuery = "SELECT count(*) FROM Employees", nativeQuery = true)
	Page<Object[]> findAllEmployeesObject(Pageable pageable);

	default Page<EmployeeResponseDTO> findAllEmployees(Pageable pageable) {
		Page<Object[]> results = findAllEmployeesObject(pageable);

		return results.map(obj -> new EmployeeResponseDTO((String) obj[0], (String) obj[1], (String) obj[2],
				(String) obj[3], (String) obj[4], (BigDecimal) obj[5], (String) obj[6], (BigDecimal) obj[7]));
	}

	boolean existsByCpfOrEmailOrTelephoneOrMatriculation(String cpf, String email, String telephone,
			String matriculation);
}