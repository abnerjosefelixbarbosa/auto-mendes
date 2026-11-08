package com.concessionaria.backend.service.imp;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.concessionaria.backend.entity.Customer;
import com.concessionaria.backend.entity.Employee;
import com.concessionaria.backend.entity.Item;
import com.concessionaria.backend.entity.Sale;
import com.concessionaria.backend.entity.Vehicle;
import com.concessionaria.backend.entity.enums.EmployeeType;
import com.concessionaria.backend.entity.enums.PaymentType;
import com.concessionaria.backend.entity.enums.VehicleStatus;
import com.concessionaria.backend.exception.ApplicationException;
import com.concessionaria.backend.exception.NotFoundException;
import com.concessionaria.backend.repository.SaleRepository;
import com.concessionaria.backend.service.CustomerService;
import com.concessionaria.backend.service.EmployeeService;
import com.concessionaria.backend.service.SaleService;
import com.concessionaria.backend.service.VehicleService;
import com.concessionaria.backend.specification.SaleSpecification;

import jakarta.transaction.Transactional;

@Service
public class SaleServiceImpl implements SaleService {
	private final SaleRepository saleRepository;
	private final CustomerService customerService;
	private final EmployeeService employeeService;
	private final VehicleService vehicleService;

	public SaleServiceImpl(SaleRepository saleRepository, CustomerService customerService,
			EmployeeService employeeService, VehicleService vehicleService) {
		this.saleRepository = saleRepository;
		this.customerService = customerService;
		this.employeeService = employeeService;
		this.vehicleService = vehicleService;
	}

	@Transactional
	public Sale registerSale(Sale sale) {
		Customer customer = customerService.findCustomerByDocument(sale.getCustomer().getDocument());

		Employee employee = employeeService.findEmployeeByMatriculation(sale.getEmployee().getMatriculation());

		sale.setCustomer(customer);

		sale.setEmployee(employee);

		List<Item> items = mapItems(sale);

		sale.setItems(items);

		validadeSale(sale);

		updateVehicle(sale);

		Sale savedSale = saleRepository.save(sale);

		return savedSale;
	}

	public void deleterSaleById(String id) {
		Sale foundSale = saleRepository.findById(id).orElseThrow(() -> new NotFoundException("Id deve ser existente."));

		saleRepository.delete(foundSale);
	}

	public Page<Sale> listSales(PaymentType paymentType, Pageable pageable) {
		Page<Sale> page = saleRepository.findAll(SaleSpecification.filter(paymentType), pageable);

		return page;
	}

	private List<Item> mapItems(Sale sale) {
		List<Item> items = sale.getItems().stream().map(item -> {
			Vehicle vehicle = vehicleService.findVehicleByPlate(item.getVehicle().getPlate());

			Item newItem = new Item(null, sale, vehicle);

			BigDecimal total = sale.getTotalValue().add(vehicle.getPrice());

			sale.setTotalValue(total);

			newItem.setSale(sale);

			return newItem;
		}).toList();
		
		return items;
	}

	private void updateVehicle(Sale sale) {
		sale.getItems().stream().forEach((item) -> {
			item.getVehicle().setVehicleStatus(VehicleStatus.SOLD);

			vehicleService.updateVehicleByPlate(item.getVehicle().getPlate(), item.getVehicle());
		});
	}

	private void validadeSale(Sale sale) {
		if (sale.getEmployee().getEmployeeType() != EmployeeType.SELLER) {
			throw new ApplicationException("Matricula do funcionário deve ser de um vendedor.");
		}

		sale.getItems().stream().forEach((item) -> {
			if (item.getVehicle().getVehicleStatus() == VehicleStatus.SOLD) {
				throw new ApplicationException("Lista de itens deve ter veiculos a venda.");
			}
		});
	}
}
