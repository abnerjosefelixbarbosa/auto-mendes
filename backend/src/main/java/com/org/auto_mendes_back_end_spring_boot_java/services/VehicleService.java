package com.org.auto_mendes_back_end_spring_boot_java.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.auto_mendes_back_end_spring_boot_java.dtos.requests.MarkRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.requests.ModelRequestDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.responses.MarkResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.dtos.responses.ModelResponseDTO;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Mark;
import com.org.auto_mendes_back_end_spring_boot_java.entities.Model;
import com.org.auto_mendes_back_end_spring_boot_java.factories.interfaces.IMarkFactory;
import com.org.auto_mendes_back_end_spring_boot_java.factories.interfaces.IModelFactory;
import com.org.auto_mendes_back_end_spring_boot_java.repositories.interfaces.IModelRepository;
import com.org.auto_mendes_back_end_spring_boot_java.services.interfaces.IMarkService;
import com.org.auto_mendes_back_end_spring_boot_java.services.interfaces.IVehicleService;
import com.org.auto_mendes_back_end_spring_boot_java.validations.interfaces.IVehicleValidation;

@Service
public class VehicleService implements IVehicleService {
	@Autowired
	private IMarkService markService;
	@Autowired
	private IVehicleValidation vehicleValidation;
	@Autowired
	private IMarkFactory markFactory;
	@Autowired
	private IModelFactory modelFactory;
	@Autowired
	private IModelRepository modelRepository;
	
	
	public MarkResponseDTO registerMark(MarkRequestDTO dto) {
		Mark mark = markFactory.creatMark(dto);
		
		vehicleValidation.validateMark(mark);
		
		mark = markService.save(mark);
		
		return markFactory.creatMarkResponseDTO(mark);
	} 
	
	public ModelResponseDTO registerModel(ModelRequestDTO dto) {
		Model model = modelFactory.createModel(dto);
		
		//vehicleValidation.validateMark(mark);
		
		model = modelRepository.save(model);
		
		return null;
	} 
}
