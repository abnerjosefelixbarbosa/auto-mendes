package com.org.auto_mendes_back_end_java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.f4b6a3.ulid.UlidCreator;
import com.org.auto_mendes_back_end_java.dto.EmployeeRequest;
import com.org.auto_mendes_back_end_java.dto.EmployeeResponse;
import com.org.auto_mendes_back_end_java.entity.Employee;
import com.org.auto_mendes_back_end_java.repository.IEmployeeRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class EmployeeService implements IEmployeeService {
	@Autowired
	private IEmployeeRepository employeeRepository;

	@Override
	@Transactional
	public EmployeeResponse registerEmployee(EmployeeRequest request) {
		Employee employee = new Employee(request);

		validateEmployee(employee);
		
		employee.setId(UlidCreator.getUlid().toString());

		employeeRepository.save(employee);

		EmployeeResponse response = new EmployeeResponse(employee);

		return response;
	}

	@Override
	@Transactional
	public EmployeeResponse updateEmployee(String cpf, EmployeeRequest request) {
		Employee employee = new Employee(request);

		validateEmployee(employee);

		Employee employeeFound = employeeRepository.findByCpf(cpf).orElseThrow(() -> {
			throw new EntityNotFoundException("Employee not found");
		});
		
		employeeFound.setName(request.name());
		employeeFound.setCpf(request.cpf());
		employeeFound.setEmployeeType(request.employeeType());
		employeeFound.setBirthDate(request.birthDate());
		employeeFound.setContact(request.contact());
		employeeFound.setEmail(request.email());
		employeeFound.setRg(request.rg());
	
		employeeRepository.save(employeeFound);

		EmployeeResponse response = new EmployeeResponse(employeeFound);

		return response;
	}

	private void validateEmployee(Employee employee) {
		boolean isExists = employeeRepository.existsByCpfOrRgOrEmailOrContact(employee.getCpf(), employee.getRg(),
				employee.getEmail(), employee.getContact());

		if (isExists)
			throw new RuntimeException("CPF, RG, email ou contact exists");
	}
}
