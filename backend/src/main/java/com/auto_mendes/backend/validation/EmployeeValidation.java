package com.auto_mendes.backend.validation;

import com.auto_mendes.backend.entity.AssistantManager;
import com.auto_mendes.backend.entity.Manager;
import com.auto_mendes.backend.entity.Saler;

public interface EmployeeValidation {
	void validadeEmployee(Manager manager);

	void validadeEmployee(AssistantManager assistantManager);

	void validadeEmployee(Saler saler);
}