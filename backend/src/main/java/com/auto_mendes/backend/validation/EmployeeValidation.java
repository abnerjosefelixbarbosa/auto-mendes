package com.auto_mendes.backend.validation;

import com.auto_mendes.backend.persistence.entity.AssistantManager;
import com.auto_mendes.backend.persistence.entity.Manager;
import com.auto_mendes.backend.persistence.entity.Saler;

public interface EmployeeValidation {
	void validadeEmployee(Manager manager);

	void validadeEmployee(AssistantManager assistantManager);

	void validadeEmployee(Saler saler);
}