package com.org.auto_mendes_back_end_java.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.f4b6a3.ulid.UlidCreator;
import com.org.auto_mendes_back_end_java.dto.EmployeeRequest;
import com.org.auto_mendes_back_end_java.dto.EmployeeResponse;
import com.org.auto_mendes_back_end_java.entity.Employee;
import com.org.auto_mendes_back_end_java.mapper.IEmployeeMapper;
import com.org.auto_mendes_back_end_java.repository.IEmployeeRepository;
import com.org.auto_mendes_back_end_java.validation.IEmployeeValidation;

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
	public EmployeeResponse registerEmployee(EmployeeRequest request) {
		employeeValidation.validateEmployee(request);
		
		Employee employee = employeeMapper.toEmployee(request);
		
		employee.setId(UlidCreator.getUlid().toString());

		employeeRepository.save(employee);

		return employeeMapper.toEmployeeResponse(employee);
	}

	@Transactional
	public EmployeeResponse updateEmployee(String cpf, EmployeeRequest request) {
		employeeValidation.validateEmployee(request);

		Employee employee = employeeRepository
				.findByCpf(cpf)
				.orElseThrow(() -> new EntityNotFoundException("Employee not found"));
		
		BeanUtils.copyProperties(request, employee);
	
		employeeRepository.save(employee);

		return employeeMapper.toEmployeeResponse(employee);
	}
	
	public EmployeeResponse searchEmployee(String cpf) {
		Employee employee = employeeRepository
				.findByCpf(cpf)
				.orElseThrow(() -> new EntityNotFoundException("Employee not found"));
		
		return employeeMapper.toEmployeeResponse(employee);
	}
	
}
