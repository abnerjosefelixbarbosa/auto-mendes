package com.auto_mendes.backend.service;

import com.auto_mendes.backend.dto.CustomerRequestDTO;
import com.auto_mendes.backend.dto.CustomerResponseDTO;

public interface ICustomerService {
	CustomerResponseDTO registerCustomer(CustomerRequestDTO dto);
}