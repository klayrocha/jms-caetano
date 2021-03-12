package com.klayrocha.jmsproducer.service;

import org.springframework.stereotype.Service;

import com.klayrocha.jmsproducer.message.VehicleSendMessage;
import com.klayrocha.jmsproducer.model.Vehicle;
import com.klayrocha.jmsproducer.repository.VehicleRepository;
import com.klayrocha.jmsproducer.vo.VehicleVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VehicleService {

	private final VehicleRepository vehicleRepository;
	private final VehicleSendMessage vehicleSendMessage;

	public VehicleVO create(VehicleVO vehicleVO) {
		// Save Mysql
		VehicleVO vehicleVoRet = VehicleVO.create(vehicleRepository.save(Vehicle.create(vehicleVO)));
		
		// Load user
		vehicleVoRet.setUser(vehicleVO.getUser());
		vehicleVoRet.setOperation("I");
		
		// Send to RabbitMQ
		vehicleSendMessage.sendMessage(vehicleVoRet);
		return vehicleVoRet;
	}

}
