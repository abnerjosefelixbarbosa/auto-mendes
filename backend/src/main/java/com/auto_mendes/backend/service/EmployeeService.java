package com.auto_mendes.backend.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.auto_mendes.backend.dto.EmployeeRequestDTO;
import com.auto_mendes.backend.dto.EmployeeResponseDTO;
import com.auto_mendes.backend.exception.NotFoundException;
import com.auto_mendes.backend.model.Employee;
import com.auto_mendes.backend.repository.IEmployeeRepository;
import com.auto_mendes.backend.validation.IEmployeeValidation;

import jakarta.transaction.Transactional;

@Service
public class EmployeeService implements IEmployeeService {
	@Autowired
	private IEmployeeRepository employeeRepository;
	@Autowired
	private IEmployeeValidation employeeValidation;

	@Transactional
	public EmployeeResponseDTO registerEmployee(EmployeeRequestDTO dto) {
		Employee employee = new Employee(dto);

		employeeValidation.validatemployee(employee);

		if (!employee.getEmployeeType().toString().equals("SALER")) {
			employee.setCommission(null);
		}

		Employee employeeSaved = employeeRepository.save(employee);

		return new EmployeeResponseDTO(employeeSaved);
	}

	@Transactional
	public EmployeeResponseDTO updateEmployeeById(String id, EmployeeRequestDTO dto) {
		Employee employee = new Employee(dto);

		employeeValidation.validatemployee(employee);

		if (employee.getEmployeeType().ordinal() != 2) {
			employee.setCommission(null);
		}

		Employee employeeFound = employeeRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Funcionário não encontrado."));

		BeanUtils.copyProperties(employee, employeeFound, "id");

		return new EmployeeResponseDTO(employeeFound);
	}

	public Page<EmployeeResponseDTO> listEmployees(Pageable pageable) {
		Page<Employee> page = employeeRepository.findAll(pageable);

		return page.map(EmployeeResponseDTO::new);
	}

	public EmployeeResponseDTO getEmployeeById(String id) {
		Employee employeeFound = employeeRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Funcionário não encontrado."));
		
		return new EmployeeResponseDTO(employeeFound);
	}
}