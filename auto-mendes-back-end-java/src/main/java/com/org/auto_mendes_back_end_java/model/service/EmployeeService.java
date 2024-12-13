package com.org.auto_mendes_back_end_java.model.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.github.f4b6a3.ulid.UlidCreator;
import com.org.auto_mendes_back_end_java.model.dto.EmployeeRegistrationRequest;
import com.org.auto_mendes_back_end_java.model.dto.EmployeeResponse;
import com.org.auto_mendes_back_end_java.model.dto.EmployeeUpdateRequest;
import com.org.auto_mendes_back_end_java.model.entity.Employee;
import com.org.auto_mendes_back_end_java.model.mapper.IEmployeeMapper;
import com.org.auto_mendes_back_end_java.model.repository.IEmployeeRepository;
import com.org.auto_mendes_back_end_java.model.validation.IEmployeeValidation;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class EmployeeService implements IEmployeeService {
	@Autowired
	private IEmployeeRepository employeeRepository;
	@Autowired
	private IEmployeeMapper employeeMapper;
	@Autowired
	private IEmployeeValidation employeeValidation;

	@Transactional
	public EmployeeResponse registerEmployee(EmployeeRegistrationRequest request) {
		employeeValidation.validateEmployeeRegistrationRequest(request);
		
		Employee employee = employeeMapper.toEmployee(request);
		
		employee.setId(UlidCreator.getUlid().toString());

		employeeRepository.save(employee);

		return employeeMapper.toEmployeeResponse(employee);
	}

	@Transactional
	public EmployeeResponse updateEmployee(String cpf, EmployeeUpdateRequest request) {
		employeeValidation.validateEmployeeUpdateRequest(request);

		Employee employee = employeeRepository
				.findByCpf(cpf)
				.orElseThrow(() -> new EntityNotFoundException("Employee not found"));
		
		BeanUtils.copyProperties(request, employee);
	
		employeeRepository.save(employee);

		return employeeMapper.toEmployeeResponse(employee);
	}
	
	@Cacheable(value = "employee", key = "#cpf")
	public EmployeeResponse searchEmployee(String cpf) {
		return employeeRepository
				.findByCpf(cpf)
				.map(employeeMapper::toEmployeeResponse)
				.orElseThrow(() -> new EntityNotFoundException("Employee not found"));
	}

	public Page<EmployeeResponse> listEmployeeByName(String name, Pageable pageable) {	
		return employeeRepository
				.findAllByNameContaining(name, pageable)
				.map(employeeMapper::toEmployeeResponse);
	}
}
