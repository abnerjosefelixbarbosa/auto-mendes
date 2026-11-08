package com.concessionaria.backend.service.imp;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.concessionaria.backend.entity.Employee;
import com.concessionaria.backend.entity.enums.EmployeeStatus;
import com.concessionaria.backend.entity.enums.EmployeeType;
import com.concessionaria.backend.exception.ApplicationException;
import com.concessionaria.backend.exception.NotFoundException;
import com.concessionaria.backend.repository.EmployeeRepository;
import com.concessionaria.backend.service.EmployeeService;
import com.concessionaria.backend.specification.EmployeeSpecification;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private final EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Transactional
	public Employee registerEmployee(Employee employee) {
		validateEmployee(employee);

		Employee savedEmployee = employeeRepository.save(employee);

		return savedEmployee;
	}

	@Transactional
	public Employee updateEmployeeById(String id, Employee employee) {
		validateEmployee(employee);

		Employee foundEmployee = employeeRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Id deve ser existente."));

		BeanUtils.copyProperties(employee, foundEmployee, "id");

		employeeRepository.save(foundEmployee);

		return foundEmployee;
	}

	public Employee findEmployeeById(String id) {
		Employee foundEmployee = employeeRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Id deve ser existente."));

		return foundEmployee;
	}

	public Page<Employee> listEmployees(String name, EmployeeStatus employeeStatus,
			EmployeeType employeeType, Pageable pageable) {
		Page<Employee> page = employeeRepository
				.findAll(EmployeeSpecification.filter(employeeStatus, employeeType, name), pageable);

		return page;
	}

	public Employee findEmployeeByMatriculation(String matriculation) {
		Employee foundEmployee = employeeRepository.findByMatriculation(matriculation)
				.orElseThrow(() -> new NotFoundException("Matricula do funcionário deve ser existente."));

		return foundEmployee;
	}

	private void validateEmployee(Employee employee) {
		if (employee.getEmployeeType() == EmployeeType.SELLER) {
			if (employee.getCommission() == null) {
				throw new ApplicationException("Comissão deve ser obrigatório para funcionário vendedor.");
			}

			if (employee.getCommission().longValue() == 0) {
				throw new ApplicationException("Comissão deve ser obrigatório para funcionário vendedor.");
			}

			if (employee.getCommission().longValue() > 100) {
				throw new ApplicationException("Comissão deve ser menor que 100.");
			}
		} else {
			if (employee.getCommission() != null) {
				throw new ApplicationException("Comissão deve ser obrigatório para funcionário vendedor.");
			}
		}

		if (employee.getSalary().scale() != 2) {
			throw new ApplicationException("Salário deve ter 2 dígitos.");
		}

		if (employee.getSalary().toString().equals("0.00")) {
			throw new ApplicationException("Salário não deve 0.00.");
		}

		if (isExistsByNameOrMatriculationOrEmailOrPhoneOrCpf(employee)) {
			throw new ApplicationException("Nome, matrícula, email, telefone ou cpf não deve ser repetido.");
		}
	}

	private boolean isExistsByNameOrMatriculationOrEmailOrPhoneOrCpf(Employee employee) {
		return employeeRepository.existsByNameOrMatriculationOrEmailOrPhoneOrCpf(employee.getName(),
				employee.getMatriculation(), employee.getEmail(), employee.getPhone(), employee.getCpf());
	}
}
