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
		String user = vehicleVO.getUser();
		VehicleVO vehicleVoRet = VehicleVO.create(vehicleRepository.save(Vehicle.create(vehicleVO)));
		vehicleVoRet.setUser(user);
		vehicleVoRet.setOperation("I");
		vehicleSendMessage.sendMessage(vehicleVoRet);
		return vehicleVoRet;
	}

}
