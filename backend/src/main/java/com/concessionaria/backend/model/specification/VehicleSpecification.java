package com.concessionaria.backend.model.specification;

import org.springframework.data.jpa.domain.Specification;

import com.concessionaria.backend.model.entity.Vehicle;
import com.concessionaria.backend.model.entity.enums.TransmissionType;
import com.concessionaria.backend.model.entity.enums.VehicleStatus;

public class VehicleSpecification {
	private static Specification<Vehicle> byVehicleStatus(VehicleStatus vehicleStatus) {
		return (root, query, builder) -> {
			if (vehicleStatus == null) {
				return null;
			}

			return builder.equal(root.get("vehicleStatus"), vehicleStatus);
		};
	}

	private static Specification<Vehicle> byTransmissionType(TransmissionType transmissionType) {
		return (root, query, builder) -> {
			if (transmissionType == null) {
				return null;
			}

			return builder.equal(root.get("transmissionType"), transmissionType);
		};
	}

	private static Specification<Vehicle> byColor(String color) {
		return (root, query, builder) -> {
			if (color == null) {
				return null;
			}

			return builder.like(builder.upper(root.get("color")), "%" + color.toUpperCase() + "%");
		};
	}

	private static Specification<Vehicle> byPlate(String plate) {
		return (root, query, builder) -> {
			if (plate == null) {
				return null;
			}

			return builder.like(builder.upper(root.get("plate")), "%" + plate.toUpperCase() + "%");
		};
	}

	public static Specification<Vehicle> filter(TransmissionType transmissionType, VehicleStatus vehicleStatus,
			String color, String plate) {
		return Specification.where(byTransmissionType(transmissionType)).and(byVehicleStatus(vehicleStatus))
				.and(byColor(color)).and(byPlate(plate));
	}
}
