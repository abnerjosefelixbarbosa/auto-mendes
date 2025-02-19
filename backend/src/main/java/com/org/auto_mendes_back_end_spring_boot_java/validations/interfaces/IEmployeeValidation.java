package com.org.auto_mendes_back_end_spring_boot_java.validations.interfaces;

import com.org.auto_mendes_back_end_spring_boot_java.entities.DeputyManager;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Manager;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Saler;

public interface IEmployeeValidation {
	void validateEmployee(Manager manager);
	void validateEmployee(DeputyManager deputyManager);
	void validateEmployee(Saler saler);
}