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
		employeeValidation.validateEmployee(request);
		
		EmployeeResponseDTO employeeResponseDTO = null;
		
		Employee employeeSaved = null;
		
		switch (request.getEmployeeType().ordinal()) {
		case 0:
			Manager manager = employeeMapper.toEmployeeManager(request);
			
			employeeSaved = employeeRepository.save(manager);
			
			managerRepository.save(manager);
			
			employeeResponseDTO = employeeMapper.toEmployeeResponseDto(employeeSaved);
			
			break;
		case 1:
            DeputyManager deputyManager = employeeMapper.toEmployeeDeputyManager(request);
            
			employeeSaved = employeeRepository.save(deputyManager);
			
			deputyManagerRepository.save(deputyManager);
			
			employeeResponseDTO = employeeMapper.toEmployeeResponseDto(employeeSaved);
			
			break;
		case 2:
			Saler saler = employeeMapper.toEmployeeSaler(request);
			
			employeeSaved = employeeRepository.save(saler);
			
			salerRepository.save(saler);
			
			employeeResponseDTO = employeeMapper.toEmployeeResponseDto(employeeSaved);
			
			break;
		default:
			throw new RuntimeException("valor invalido");
		}

		return employeeResponseDTO;
	}

	public Page<EmployeeResponseDTO> listEmployees(Pageable pageable) {
		return employeeRepository.findAll(pageable).map(EmployeeResponseDTO::new);
	}
	
	public Page<EmployeeResponseDTO> listEmployeesByPosition(Pageable pageable, EmployeeType employeeType) {
		Page<EmployeeResponseDTO> employeeResponseDtoPage = null;
		
		switch (employeeType.ordinal()) {
		case 0:
			employeeResponseDtoPage = managerRepository.findAll(pageable).map(EmployeeResponseDTO::new);
			
			break;
		case 1:
			employeeResponseDtoPage = deputyManagerRepository.findAll(pageable).map(EmployeeResponseDTO::new);
			
			break;
		case 2:
			employeeResponseDtoPage = salerRepository.findAll(pageable).map(EmployeeResponseDTO::new);
			
			break;
		default:
			throw new RuntimeException("valor invalido");
		}
		
		return employeeResponseDtoPage;
	} 
}