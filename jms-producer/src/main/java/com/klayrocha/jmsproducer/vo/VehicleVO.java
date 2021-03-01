package com.klayrocha.jmsproducer.vo;

import java.io.Serializable;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.klayrocha.jmsproducer.model.Vehicle;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@JsonPropertyOrder({ "id", "brand", "model", "price" })
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class VehicleVO implements Serializable {

	private static final long serialVersionUID = -1323419550080590813L;

	@JsonProperty("id")
	private Long id;

	@JsonProperty("brand")
	private String brand;

	@JsonProperty("model")
	private String model;

	@JsonProperty("price")
	private Double price;

	public static VehicleVO create(Vehicle vehicle) {
		return new ModelMapper().map(vehicle, VehicleVO.class);
	}

}
