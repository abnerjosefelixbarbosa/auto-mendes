package com.auto_mendes.backend.validation.impl;

import org.springframework.stereotype.Component;

import com.auto_mendes.backend.model.entity.AssistantManager;
import com.auto_mendes.backend.model.entity.Manager;
import com.auto_mendes.backend.model.entity.Saler;
import com.auto_mendes.backend.repository.AssistantManagerRepository;
import com.auto_mendes.backend.repository.ManagerRepository;
import com.auto_mendes.backend.repository.SalerRepository;
import com.auto_mendes.backend.validation.EmployeeValidation;

import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EmployeeValidationImpl implements EmployeeValidation {
	private final ManagerRepository managerRepository;
	private final AssistantManagerRepository assistantManagerRepository;
	private final SalerRepository salerRepository;

	public void validadeEmployee(Manager manager) {
		boolean isExists = managerRepository.existsByEmailOrMatriculationOrPhone(manager.getEmail(),
				manager.getMatriculation(), manager.getPhone());

		if (isExists) {
			throw new EntityExistsException("Email, matrícula ou telefone não ser repedidos.");
		}
	}

	public void validadeEmployee(AssistantManager assistantManager) {
		boolean isExists = assistantManagerRepository.existsByEmailOrMatriculationOrPhone(assistantManager.getEmail(),
				assistantManager.getMatriculation(), assistantManager.getPhone());

		if (isExists) {
			throw new EntityExistsException("Email, matrícula ou telefone não ser repedidos.");
		}
	}

	public void validadeEmployee(Saler saler) {
		boolean isExists = salerRepository.existsByEmailOrMatriculationOrPhone(saler.getEmail(),
				saler.getMatriculation(), saler.getPhone());

		if (isExists) {
			throw new RuntimeException("Email, matrícula ou telefone não ser repedidos.");
		}
		if (saler.getCommission().precision() > 20) {
			throw new RuntimeException("Comissão deve ter menos de 20 digitos antes da vírgula.");
		}
		if (saler.getCommission().scale() != 2) {
			throw new RuntimeException("Comissão deve ter 2 digitos depois da vírgula.");
		}
	}
}