package com.auto_mendes.backend.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.auto_mendes.backend.model.Manager;
import com.auto_mendes.backend.model.Saler;
import com.auto_mendes.backend.model.Submanager;
import com.auto_mendes.backend.repository.IManagerRepository;
import com.auto_mendes.backend.repository.ISalerRepository;
import com.auto_mendes.backend.repository.ISubmanagerRepository;

@Component
public class EmployeeValidation implements IEmployeeValidation {
	@Autowired
	private IManagerRepository managerRepository;
	@Autowired
	private ISubmanagerRepository submanagerRepository;
	@Autowired
	private ISalerRepository salerRepository;
	
	public void validateManager(Manager manager) {
		boolean isExistsEmailOrMatriculationOrPhone = managerRepository
				.existsByEmailOrMatriculationOrPhone(manager.getEmail(), manager.getMatriculation(), manager.getPhone());
		
		if (isExistsEmailOrMatriculationOrPhone) {
			throw new RuntimeException("Email, matrícula ou telefone não deve ser duplicados");
		}
	}
	
	public void validateSubmanager(Submanager submanager) {
		boolean isExistsEmailOrMatriculationOrPhone = submanagerRepository
				.existsByEmailOrMatriculationOrPhone(submanager.getEmail(), submanager.getMatriculation(), submanager.getPhone());
		
		if (isExistsEmailOrMatriculationOrPhone) {
			throw new RuntimeException("Email, matrícula ou telefone não deve ser duplicados");
		}
	}
	
	public void validateSaler(Saler saler) {
		boolean isExistsEmailOrMatriculationOrPhone = salerRepository
				.existsByEmailOrMatriculationOrPhone(saler.getEmail(), saler.getMatriculation(), saler.getPhone());
		
		if (isExistsEmailOrMatriculationOrPhone) {
			throw new RuntimeException("Email, matrícula ou telefone não deve ser duplicados");
		}
		
		if (saler.getCommission().scale() != 2) {
			throw new RuntimeException("Comissão deve ter dois digitos depois da vírgula.");
		}
	}
}