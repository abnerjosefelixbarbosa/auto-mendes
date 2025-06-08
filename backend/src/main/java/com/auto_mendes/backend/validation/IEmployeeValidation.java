package com.auto_mendes.backend.validation;

import com.auto_mendes.backend.model.Manager;
import com.auto_mendes.backend.model.Saler;
import com.auto_mendes.backend.model.Submanager;

public interface IEmployeeValidation {
	void validateManager(Manager manager);

	void validateSubmanager(Submanager submanager);

	void validateSaler(Saler saler);
}