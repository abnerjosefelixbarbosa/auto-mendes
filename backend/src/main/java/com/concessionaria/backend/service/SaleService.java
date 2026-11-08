package com.concessionaria.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.concessionaria.backend.entity.Sale;
import com.concessionaria.backend.entity.enums.PaymentType;

public interface SaleService {
	Sale registerSale(Sale sale);

	void deleterSaleById(String id);

	Page<Sale> listSales(PaymentType paymentType, Pageable pageable);
}