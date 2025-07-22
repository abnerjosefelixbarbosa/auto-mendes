package com.auto_mendes.backend.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.auto_mendes.backend.dto.VehicleRequestDTO;
import com.auto_mendes.backend.enums.TransmissionType;
import com.auto_mendes.backend.enums.VehicleType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "vehicle_tb")
public class Vehicle implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id")
	private String id;
	@Column(name = "plate", length = 15)
    private String plate;
	@Column(name = "transmission_type", nullable = false)
    private TransmissionType transmissionType;
	@Column(name = "price", nullable = false)
    private BigDecimal price;
	@Column(name = "vehicle_type", nullable = false)
	private VehicleType vehicleType;
	@ManyToOne
	@JoinColumn(columnDefinition = "model_id", nullable = false)
	private Model model;
	@OneToMany(mappedBy = "vehicle", cascade = CascadeType.MERGE)
	private List<SaleVehicle> saleVehicles;
	
	public Vehicle(VehicleRequestDTO dto) {
		Model model = new Model();
		model.setName(dto.getModelName());
		BeanUtils.copyProperties(dto, this);
		this.model = model;
	}
}