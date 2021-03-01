package com.klayrocha.jmsproducer.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.klayrocha.jmsproducer.vo.VehicleVO;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "vehicle")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Vehicle implements Serializable {

	private static final long serialVersionUID = -8821904495475747712L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "brand", nullable = false, length = 255)
	private String brand;

	@Column(name = "model", nullable = false, length = 255)
	private String model;

	@Column(name = "price", nullable = false, length = 10)
	private Double price;

	public static Vehicle create(VehicleVO vehicleVO) {
		return new ModelMapper().map(vehicleVO, Vehicle.class);
	}

}
