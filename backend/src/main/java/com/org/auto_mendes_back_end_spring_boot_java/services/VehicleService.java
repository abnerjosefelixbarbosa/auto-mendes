package com.org.auto_mendes_back_end_spring_boot_java.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.requests.MarkRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.responses.MarkResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Mark;
import com.org.auto_mendes_back_end_spring_boot_java.factories.interfaces.IMarkFactory;
import com.org.auto_mendes_back_end_spring_boot_java.repositories.interfaces.IMarkRepository;
import com.org.auto_mendes_back_end_spring_boot_java.services.interfaces.IVehicleService;
import com.org.auto_mendes_back_end_spring_boot_java.validations.interfaces.IVehicleValidation;

@Service
public class VehicleService implements IVehicleService {
	@Autowired
	private IMarkRepository markRepository;
	@Autowired
	private IVehicleValidation vehicleValidation;
	@Autowired
	private IMarkFactory markFactory;
	
	public MarkResponseDTO registerMark(MarkRequestDTO dto) {
		Mark mark = markFactory.creatMark(dto);
		
		vehicleValidation.validateMark(mark);
		
		mark = markRepository.save(mark);
		
		return markFactory.creatMarkResponseDTO(mark);
	} 
}
