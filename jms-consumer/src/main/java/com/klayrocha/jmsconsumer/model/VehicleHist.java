package com.klayrocha.jmsconsumer.model;

import java.io.Serializable;

import org.modelmapper.ModelMapper;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.klayrocha.jmsconsumer.vo.VehicleVO;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Document
public class VehicleHist implements Serializable {

	private static final long serialVersionUID = -8821904495475747712L;

	@Id
	private String id;
	
	private Long idVehicle;
	private String brand;
	private String model;
	private Double price;
	private String user;
	private String operation;

	public static VehicleHist create(VehicleVO vehicleVO) {
		return new ModelMapper().map(vehicleVO, VehicleHist.class);
	}
}
