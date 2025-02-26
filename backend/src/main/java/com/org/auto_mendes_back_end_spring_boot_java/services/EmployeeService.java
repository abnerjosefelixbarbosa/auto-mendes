package com.org.auto_mendes_back_end_spring_boot_java.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.requests.EmployeeRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.responses.EmployeeResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.entities.DeputyManager;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Manager;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Saler;
import com.org.auto_mendes_back_end_spring_boot_java.enums.EmployeeType;
import com.org.auto_mendes_back_end_spring_boot_java.exceptions.NotFoundException;
import com.org.auto_mendes_back_end_spring_boot_java.exceptions.ValidationException;
import com.org.auto_mendes_back_end_spring_boot_java.mappers.interfaces.IEmployeeMapper;
import com.org.auto_mendes_back_end_spring_boot_java.repositories.interfaces.IDeputyManagerRepository;
import com.org.auto_mendes_back_end_spring_boot_java.repositories.interfaces.IEmployeeRepository;
import com.org.auto_mendes_back_end_spring_boot_java.repositories.interfaces.IManagerRepository;
import com.org.auto_mendes_back_end_spring_boot_java.repositories.interfaces.ISalerRepository;
import com.org.auto_mendes_back_end_spring_boot_java.services.interfaces.IEmployeeService;
import com.org.auto_mendes_back_end_spring_boot_java.validations.interfaces.IEmployeeValidation;

import jakarta.transaction.Transactional;

@Service
public class EmployeeService implements IEmployeeService {
	@Autowired
	private IEmployeeRepository employeeRepository;
	@Autowired
	private ISalerRepository salerRepository;
	@Autowired
	private IManagerRepository managerRepository;
	@Autowired
	private IDeputyManagerRepository deputyManagerRepository;
	@Autowired
	private IEmployeeValidation employeeValidation;
	@Autowired
	private IEmployeeMapper employeeMapper;

	@Transactional
	public EmployeeResponseDTO registerEmployee(EmployeeRequestDTO dto) {
		EmployeeResponseDTO employeeResponseDTO = null;
		
		switch (dto.getEmployeeType().ordinal()) {
		case 0:
			Manager manager = employeeMapper.toManager(dto);

			employeeValidation.validateEmployee(manager);

			employeeRepository.save(manager);
			manager = managerRepository.save(manager);

			employeeResponseDTO = employeeMapper.toEmployeeResponseDTO(manager);
			break;
		case 1:
			DeputyManager deputyManager = employeeMapper.toDeputyManager(dto);

			employeeValidation.validateEmployee(deputyManager);

			employeeRepository.save(deputyManager);
			deputyManager = deputyManagerRepository.save(deputyManager);

			employeeResponseDTO = employeeMapper.toEmployeeResponseDTO(deputyManager);
			break;
		case 2:
			Saler saler = employeeMapper.toSaler(dto);
			
			employeeValidation.validateEmployee(saler);

			employeeRepository.save(saler);
			saler = salerRepository.save(saler);

			employeeResponseDTO = employeeMapper.toEmployeeResponseDTO(saler);
			break;
		default:
			throw new ValidationException("Valor inexperado: " + dto.getEmployeeType().ordinal());
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
			page = managerRepository.findAll(pageable).map(employeeMapper::toEmployeeResponseDTO);
			break;
		case 1:
			page = deputyManagerRepository.findAll(pageable).map(employeeMapper::toEmployeeResponseDTO);
			break;
		case 2:
			page = salerRepository.findAll(pageable).map(employeeMapper::toEmployeeResponseDTO);
			break;
		}

		return page;
	}

	public Page<EmployeeResponseDTO> listEmployeesByMatriculation(Pageable pageable, String matriculation) {
		return employeeRepository.listEmployeesByMatriculation(pageable, matriculation);
	}

	@Transactional
	public EmployeeResponseDTO updateEmployeeById(String id, EmployeeRequestDTO dto) {
		EmployeeResponseDTO employeeResponseDTO = null;
		
		switch (dto.getEmployeeType().ordinal()) {
		case 0:
			Manager manager = employeeMapper.toManager(dto);

			employeeValidation.validateEmployee(manager);
			
			Manager managerFound = managerRepository.findById(id)
					.orElseThrow(() -> new NotFoundException("Manager não emcontrado"));
			managerFound.setCpf(manager.getCpf());
			managerFound.setEmail(manager.getEmail());
			managerFound.setMatriculation(manager.getMatriculation());
			managerFound.setName(manager.getName());
			managerFound.setSalary(manager.getSalary());
			managerFound.setTelephone(manager.getTelephone());

			employeeRepository.save(managerFound);
			manager = managerRepository.save(managerFound);

			employeeResponseDTO = employeeMapper.toEmployeeResponseDTO(manager);
			break;
		case 1:
			DeputyManager deputyManager = employeeMapper.toDeputyManager(dto);
			
			employeeValidation.validateEmployee(deputyManager);
			
			DeputyManager deputyManagerFound = deputyManagerRepository.findById(id)
					.orElseThrow(() -> new NotFoundException("DeputyManager não emcontrado"));
			deputyManagerFound.setCpf(deputyManager.getCpf());
			deputyManagerFound.setEmail(deputyManager.getEmail());
			deputyManagerFound.setMatriculation(deputyManager.getMatriculation());
			deputyManagerFound.setName(deputyManager.getName());
			deputyManagerFound.setSalary(deputyManager.getSalary());
			deputyManagerFound.setTelephone(deputyManager.getTelephone());

			employeeRepository.save(deputyManagerFound);
			deputyManager = deputyManagerRepository.save(deputyManagerFound);

			employeeResponseDTO = employeeMapper.toEmployeeResponseDTO(deputyManager);
			break;
		case 2:
			Saler saler = employeeMapper.toSaler(dto);
			
			employeeValidation.validateEmployee(saler);
			
			Saler salerFound = salerRepository.findById(id)
					.orElseThrow(() -> new NotFoundException("Saler não emcontrado"));
			salerFound.setCpf(saler.getCpf());
			salerFound.setEmail(saler.getEmail());
			salerFound.setMatriculation(saler.getMatriculation());
			salerFound.setName(saler.getName());
			salerFound.setSalary(saler.getSalary());
			salerFound.setTelephone(saler.getTelephone());
			salerFound.setCommission(saler.getCommission());

			employeeRepository.save(salerFound);
			saler = salerRepository.save(salerFound);

			employeeResponseDTO = employeeMapper.toEmployeeResponseDTO(saler);
			break;
		default:
			throw new ValidationException("Valor inexperado: " + dto.getEmployeeType().ordinal());
		}

		return employeeResponseDTO;
	}
}