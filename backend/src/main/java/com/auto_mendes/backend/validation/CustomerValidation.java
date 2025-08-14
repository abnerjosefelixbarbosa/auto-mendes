package com.auto_mendes.backend.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.auto_mendes.backend.exception.BusinessException;
import com.auto_mendes.backend.model.Customer;
import com.auto_mendes.backend.repository.ICustomerRepository;

import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.CPFValidator;

@Component
public class CustomerValidation implements ICustomerValidation {
	@Autowired
	private ICustomerRepository customerRepository;
	

	public void validateCustomer(Customer customer) {
		boolean isExists = customerRepository.existsByDocumentOrEmailOrPhone(customer.getDocument(), customer.getEmail(), customer.getPhone());
		CPFValidator cpfValidator = new CPFValidator();
		CNPJValidator cnpjValidator = new CNPJValidator();
		
		if (customer.getCustomerType().toString().equals("PF")) {
			try {
				cpfValidator.assertValid(customer.getDocument());
			} catch (Exception e) {
				throw new BusinessException("Documento deve ser invalido.");
			}
		} else {
			try {
				cnpjValidator.assertValid(customer.getDocument());
			} catch (Exception e) {
				throw new BusinessException("Documento deve ser invalido.");
			}
		}
		
		if (isExists) {
			throw new BusinessException("Documento, email ou telefone deve ser único.");
		}
	}
}
