package com.org.auto_mendes_back_end_spring_boot_java.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.entities.DeputyManager;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Employee;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Manager;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Saler;
import com.org.auto_mendes_back_end_spring_boot_java.enums.EmployeeType;
import com.org.auto_mendes_back_end_spring_boot_java.exceptions.NotFoundException;
import com.org.auto_mendes_back_end_spring_boot_java.exceptions.ValidationException;
import com.org.auto_mendes_back_end_spring_boot_java.mappers.EmployeeMapperInterface;
import com.org.auto_mendes_back_end_spring_boot_java.repositories.DeputyManagerRepositoryInterface;
import com.org.auto_mendes_back_end_spring_boot_java.repositories.EmployeeRepositoryInterface;
import com.org.auto_mendes_back_end_spring_boot_java.repositories.ManagerRepositoryInterface;
import com.org.auto_mendes_back_end_spring_boot_java.repositories.SalerRepositoryInterface;
import com.org.auto_mendes_back_end_spring_boot_java.validations.EmployeeValidationInterface;

@Service
public class EmployeeService implements EmployeeServiceInterface {
	@Autowired
	private EmployeeRepositoryInterface employeeRepository;
	@Autowired
	private SalerRepositoryInterface salerRepository;
	@Autowired
	private ManagerRepositoryInterface managerRepository;
	@Autowired
	private DeputyManagerRepositoryInterface deputyManagerRepository;
	@Autowired
	private EmployeeValidationInterface employeeValidation;
	@Autowired
	private EmployeeMapperInterface employeeMapper;

	public EmployeeResponseDTO registerEmployee(EmployeeRequestDTO request) {
		Employee employee = employeeMapper.toEmployee(request);
		Manager manager = employeeMapper.toEmployeeManager(request);
		DeputyManager deputyManager = employeeMapper.toEmployeeDeputyManager(request);
		Saler saler = employeeMapper.toEmployeeSaler(request);
		EmployeeResponseDTO employeeResponseDTO = null;

		employeeValidation.validateEmployee(employee, saler, request.getEmployeeType().ordinal());

		switch (request.getEmployeeType().ordinal()) {
		case 0:
			employeeRepository.save(employee);
			Manager managerSaved = managerRepository.save(manager);
			employeeResponseDTO = employeeMapper.toEmployeeResponseDto(managerSaved, null);
			break;
		case 1:
			employeeRepository.save(deputyManager);
			DeputyManager deputyManagerSaved = deputyManagerRepository.save(deputyManager);
			employeeResponseDTO = employeeMapper.toEmployeeResponseDto(deputyManagerSaved, null);
			break;
		case 2:
			employeeRepository.save(saler);
			Saler salerSaved = salerRepository.save(saler);
			employeeResponseDTO = employeeMapper.toEmployeeResponseDto(salerSaved, salerSaved);
			break;
		default:
			throw new ValidationException("Valor invalido");
		}

		return employeeResponseDTO;
	}

	public Page<EmployeeResponseDTO> listEmployees(Pageable pageable) {
		return employeeRepository.listEmployees(pageable);
	}

	public Page<EmployeeResponseDTO> listEmployeesByPosition(Pageable pageable, EmployeeType employeeType) {
		Page<EmployeeResponseDTO> page = null;

		switch (employeeType.ordinal()) {
		case 0:
			page = managerRepository.findAll(pageable)
					.map((manager) -> employeeMapper.toEmployeeResponseDto(manager, null));
			break;
		case 1:
			page = deputyManagerRepository.findAll(pageable)
					.map((deputyManager) -> employeeMapper.toEmployeeResponseDto(deputyManager, null));
			break;
		case 2:
			page = salerRepository.findAll(pageable).map((saler) -> employeeMapper.toEmployeeResponseDto(saler, saler));
			break;
		default:
			throw new ValidationException("Valor invalido");
		}

		return page;
	}

	public Page<EmployeeResponseDTO> listEmployeesByMatriculation(Pageable pageable, String matriculation) {
		return employeeRepository.listEmployeesByMatriculation(pageable, matriculation);
	}

	public EmployeeResponseDTO updateEmployeeById(String id, EmployeeRequestDTO request) {
		Employee employee = employeeMapper.toEmployee(request);
		Manager manager = employeeMapper.toEmployeeManager(request);
		DeputyManager deputyManager = employeeMapper.toEmployeeDeputyManager(request);
		Saler saler = employeeMapper.toEmployeeSaler(request);
		EmployeeResponseDTO employeeResponseDTO = null;

		employeeValidation.validateEmployee(employee, saler, request.getEmployeeType().ordinal());

		switch (request.getEmployeeType().ordinal()) {
		case 0:
			Manager managerFound = managerRepository.findById(id)
					.orElseThrow(() -> new NotFoundException("Employee não emcontrado"));
			managerFound.setCpf(manager.getCpf());
			managerFound.setEmail(manager.getEmail());
			managerFound.setMatriculation(manager.getMatriculation());
			managerFound.setName(manager.getName());
			managerFound.setSalary(manager.getSalary());
			managerFound.setTelephone(manager.getTelephone());
			employeeRepository.save(managerFound);
			Manager managerSaved = managerRepository.save(managerFound);
			employeeResponseDTO = employeeMapper.toEmployeeResponseDto(managerSaved, null);
			break;
		case 1:
			DeputyManager deputyManagerFound = deputyManagerRepository.findById(id)
					.orElseThrow(() -> new NotFoundException("Employee não emcontrado"));
			deputyManagerFound.setCpf(deputyManager.getCpf());
			deputyManagerFound.setEmail(deputyManager.getEmail());
			deputyManagerFound.setMatriculation(deputyManager.getMatriculation());
			deputyManagerFound.setName(deputyManager.getName());
			deputyManagerFound.setSalary(deputyManager.getSalary());
			deputyManagerFound.setTelephone(deputyManager.getTelephone());
			employeeRepository.save(deputyManagerFound);
			DeputyManager deputyManagerSaved = deputyManagerRepository.save(deputyManagerFound);
			employeeResponseDTO = employeeMapper.toEmployeeResponseDto(deputyManagerSaved, null);
			break;
		case 2:
			Saler salerFound = salerRepository.findById(id)
					.orElseThrow(() -> new NotFoundException("Employee não emcontrado"));
			salerFound.setCpf(saler.getCpf());
			salerFound.setEmail(saler.getEmail());
			salerFound.setMatriculation(saler.getMatriculation());
			salerFound.setName(saler.getName());
			salerFound.setSalary(saler.getSalary());
			salerFound.setTelephone(saler.getTelephone());
			salerFound.setCommission(saler.getCommission());
			employeeRepository.save(salerFound);
			Saler salerSaved = salerRepository.save(salerFound);
			employeeResponseDTO = employeeMapper.toEmployeeResponseDto(salerSaved, salerSaved);
			break;
		default:
			throw new ValidationException("Valor invalido");
		}

		return employeeResponseDTO;
	}
}