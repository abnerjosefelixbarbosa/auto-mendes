package com.org.auto_mendes_back_end_spring_boot_java.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.EmployeeSalerResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.entities.DeputyManager;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Manager;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Saler;
import com.org.auto_mendes_back_end_spring_boot_java.enums.EmployeeType;
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

	public Object registerEmployee(EmployeeRequestDTO request) {
		employeeValidation.validateEmployee(request);
		
		Object object = null;
		
		switch (request.getEmployeeType().ordinal()) {
		case 0:
			Manager manager = employeeMapper.toEmployeeManager(request);
			
			employeeRepository.save(manager);
			
			Manager managerSaved = managerRepository.save(manager);
			
			object = new EmployeeResponseDTO(managerSaved);
			
			break;
		case 1:
            DeputyManager deputyManager = employeeMapper.toEmployeeDeputyManager(request);
            
			employeeRepository.save(deputyManager);
			
			DeputyManager deputyManagerSaved = deputyManagerRepository.save(deputyManager);
			
			object = new EmployeeResponseDTO(deputyManagerSaved);
			
			break;
		case 2:
			Saler saler = employeeMapper.toEmployeeSaler(request);
			
			employeeRepository.save(saler);
			
			Saler salerSaved = salerRepository.save(saler);
			
			object = new EmployeeSalerResponseDTO(salerSaved);
			
			break;
		default:
			throw new RuntimeException("valor invalido");
		}

		return object;
	}

	public Page<Object> listEmployees(Pageable pageable) {
		return employeeRepository.findAll(pageable).map(EmployeeResponseDTO::new);
	}
	
	public Page<Object> listEmployeesByPosition(Pageable pageable, EmployeeType employeeType) {
		Page<Object> object = null;
		
		switch (employeeType.ordinal()) {
		case 0:
			object = managerRepository.findAll(pageable).map(EmployeeResponseDTO::new);
			
			break;
		case 1:
			object = deputyManagerRepository.findAll(pageable).map(EmployeeResponseDTO::new);
			
			break;
		case 2:
			object = salerRepository.findAll(pageable).map(EmployeeSalerResponseDTO::new);
			
			break;
		default:
			throw new RuntimeException("valor invalido");
		}
		
		return object;
	} 
}