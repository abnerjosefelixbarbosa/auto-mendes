package com.auto_mendes.backend.validation;

import com.auto_mendes.backend.model.AssistantManager;
import com.auto_mendes.backend.model.Manager;
import com.auto_mendes.backend.model.Saler;

public interface EmployeeValidation {
	void validadeEmployee(Manager manager);

	void validadeEmployee(AssistantManager assistantManager);

	void validadeEmployee(Saler saler);
}