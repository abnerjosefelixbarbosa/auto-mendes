package com.org.auto_mendes_back_end_spring_boot_java.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.auto_mendes_back_end_spring_boot_java.entities.Mark;
import com.org.auto_mendes_back_end_spring_boot_java.exceptions.ValidationException;
import com.org.auto_mendes_back_end_spring_boot_java.repositories.interfaces.IMarkRepository;
import com.org.auto_mendes_back_end_spring_boot_java.validations.interfaces.IVehicleValidation;

@Component
public class VehicleValidation implements IVehicleValidation {
	@Autowired
	private IMarkRepository markRepository;
	
	public void validateMark(Mark mark) {
		boolean isExistsMark = markRepository.existsByName(mark.getName());
		
		if (isExistsMark) {
			throw new ValidationException("Nome deve ser único");
		}
	}
	
}