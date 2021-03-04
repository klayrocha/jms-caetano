package com.klayrocha.jmsconsumer.service;

import org.springframework.stereotype.Service;

import com.klayrocha.jmsconsumer.model.VehicleHist;
import com.klayrocha.jmsconsumer.repository.VehicleRepository;
import com.klayrocha.jmsconsumer.vo.VehicleVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VehicleService {

	private final VehicleRepository vehicleRepository;

	public void create(VehicleVO vehicleVO) {
		vehicleRepository.save(VehicleHist.create(vehicleVO));
	}

}
