package com.concessionaria.backend.service.imp;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.concessionaria.backend.entity.Brand;
import com.concessionaria.backend.entity.Model;
import com.concessionaria.backend.exception.ApplicationException;
import com.concessionaria.backend.exception.NotFoundException;
import com.concessionaria.backend.repository.ModelRepository;
import com.concessionaria.backend.service.BrandService;
import com.concessionaria.backend.service.ModelService;
import com.concessionaria.backend.specification.ModelSpecification;

import jakarta.transaction.Transactional;

@Service
public class ModelServiceImpl implements ModelService {
	private final ModelRepository modelRepository;
	private final BrandService brandService;

	public ModelServiceImpl(ModelRepository modelRepository, BrandService brandService) {
		this.modelRepository = modelRepository;
		this.brandService = brandService;
	}

	@Transactional
	public Model registerModel(Model model) {
		validadeModel(model);

		Brand brand = brandService.findByName(model.getBrand().getName());

		model.setBrand(brand);

		Model savedModel = modelRepository.save(model);

		return savedModel;
	}

	@Transactional
	public Model updateModelById(String id, Model model) {
		validadeModel(model);

		Brand brand = brandService.findByName(model.getBrand().getName());

		model.setBrand(brand);

		Model foundModel = modelRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Id deve ser existente."));

		BeanUtils.copyProperties(model, foundModel, "id");

		modelRepository.save(foundModel);

		return foundModel;
	}

	public Model findModelById(String id) {
		Model foundModel = modelRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Id deve ser existente."));

		return foundModel;
	}

	public Model findModelByName(String name) {
		Model foundModel = modelRepository.findByName(name)
				.orElseThrow(() -> new NotFoundException("Nome do modelo deve ser existente."));

		return foundModel;
	}

	public Page<Model> listModels(String name, Pageable pageable) {
		Page<Model> page = modelRepository.findAll(ModelSpecification.filter(name), pageable);

		return page;
	}

	private void validadeModel(Model model) {
		boolean isExistsByName = modelRepository.existsByName(model.getName());

		if (isExistsByName) {
			throw new ApplicationException("Nome não deve ser repetido.");
		}
	}
}