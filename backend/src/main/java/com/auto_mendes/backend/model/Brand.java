package com.auto_mendes.backend.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.auto_mendes.backend.dto.BrandRequestDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "brand_tb")
public class Brand implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id")
	private String id;
	@Column(name = "name", nullable = false, length = 50)
	private String name;
	@OneToMany(mappedBy = "brand", cascade = CascadeType.MERGE)
	private List<Model> models;
	
	public Brand(BrandRequestDTO dto) {
		BeanUtils.copyProperties(dto, this);
	}
}