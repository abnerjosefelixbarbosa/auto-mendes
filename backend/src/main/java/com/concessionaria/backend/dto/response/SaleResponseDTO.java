package com.concessionaria.backend.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.concessionaria.backend.entity.enums.PaymentType;

public record SaleResponseDTO(
		String id,
		LocalDate saleDate,
		PaymentType paymentType,
		BigDecimal totalValue,
		EmployeeResponseDTO employee,
		CustomerResponseDTO customer,
		List<ItemResponseDTO> items
) {}