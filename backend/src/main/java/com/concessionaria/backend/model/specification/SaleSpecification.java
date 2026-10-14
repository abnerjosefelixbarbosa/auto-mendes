package com.concessionaria.backend.model.specification;

import org.springframework.data.jpa.domain.Specification;

import com.concessionaria.backend.model.entity.Sale;
import com.concessionaria.backend.model.entity.enums.PaymentType;

public class SaleSpecification {
	private static Specification<Sale> byPaymentType(PaymentType paymentType) {
		return (root, query, builder) -> {
			if (paymentType == null) {
				return null;
			}

			return builder.equal(root.get("paymentType"), paymentType);
		};
	}

	public static Specification<Sale> filter(PaymentType paymentType) {
		return Specification.where(byPaymentType(paymentType));
	}
}
