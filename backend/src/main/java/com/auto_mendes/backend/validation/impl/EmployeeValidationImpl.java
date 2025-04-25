package com.auto_mendes.backend.validation.impl;

import org.springframework.stereotype.Component;

import com.auto_mendes.backend.model.AssistantManager;
import com.auto_mendes.backend.model.Manager;
import com.auto_mendes.backend.model.Saler;
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
	}
}