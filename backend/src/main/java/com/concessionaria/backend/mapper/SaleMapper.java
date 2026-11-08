package com.concessionaria.backend.mapper;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.concessionaria.backend.dto.request.SaleRequestDTO;
import com.concessionaria.backend.dto.request.VehicleRequestDTO;
import com.concessionaria.backend.dto.response.CustomerResponseDTO;
import com.concessionaria.backend.dto.response.EmployeeResponseDTO;
import com.concessionaria.backend.dto.response.ItemResponseDTO;
import com.concessionaria.backend.dto.response.SaleResponseDTO;
import com.concessionaria.backend.dto.response.VehicleResponseDTO;
import com.concessionaria.backend.entity.Customer;
import com.concessionaria.backend.entity.Employee;
import com.concessionaria.backend.entity.Item;
import com.concessionaria.backend.entity.Sale;
import com.concessionaria.backend.entity.Vehicle;

public class SaleMapper {
	public static Sale toSale(SaleRequestDTO request) {
		Customer customer = new Customer(null, null, request.customerDocument(), null, null, null, null);

		Employee employee = new Employee(null, null, request.employeeMatriculation(), null, null, null, null, null, null, null,
				null, null);

		List<Item> items = request.items().stream().map((value) -> {
			VehicleRequestDTO vehicleRequestDTO = value.vehicle();
			
			Vehicle vehicle = new Vehicle(null, vehicleRequestDTO.plate(), null, null, null, null, null, null);

			Item item = new Item(null, null, vehicle);

			return item;
		}).toList();

		Sale sale = new Sale(null, LocalDate.now(), request.paymentType(), BigDecimal.ZERO, employee, customer, items);

		return sale;
	}

	public static SaleResponseDTO toSaleResponseDTO(Sale sale) {
		Customer customer = sale.getCustomer();

		Employee employee = sale.getEmployee();

		EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO(employee.getId(), employee.getName(),
				employee.getMatriculation(), employee.getEmail(), employee.getPhone(), null, employee.getCpf(),
				employee.getSalary(), employee.getCommission(), employee.getEmployeeStatus(),
				employee.getEmployeeType());

		CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO(customer.getId(), customer.getName(),
				customer.getDocument(), customer.getEmail(), customer.getPhone(), customer.getCustomerType());

		List<ItemResponseDTO> itemResponseDTOs = sale.getItems().stream().map((value) -> {
			Vehicle vehicle = value.getVehicle();

			VehicleResponseDTO vehicleResponseDTO = new VehicleResponseDTO(vehicle.getId(), vehicle.getPlate(),
					vehicle.getTransmissionType(), vehicle.getVehicleStatus(), vehicle.getColor(), vehicle.getPrice(),
					null);

			ItemResponseDTO itemResponseDTO = new ItemResponseDTO(vehicleResponseDTO);

			return itemResponseDTO;
		}).toList();

		SaleResponseDTO response = new SaleResponseDTO(sale.getId(), sale.getSaleDate(), sale.getPaymentType(),
				sale.getTotalValue(), employeeResponseDTO, customerResponseDTO, itemResponseDTOs);

		return response;
	}
}