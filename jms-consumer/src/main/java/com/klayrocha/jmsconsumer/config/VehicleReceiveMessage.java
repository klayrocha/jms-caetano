package com.klayrocha.jmsconsumer.config;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.klayrocha.jmsconsumer.model.VehicleHist;
import com.klayrocha.jmsconsumer.repository.VehicleRepository;
import com.klayrocha.jmsconsumer.vo.VehicleVO;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class VehicleReceiveMessage {

	private final VehicleRepository vehicleRepository;

	@RabbitListener(queues = { "${vehicle.rabbitmq.queue}" })
	public void receive(@Payload VehicleVO vehicleVO) {
		System.out.println("Leu a fila ");
		vehicleRepository.save(VehicleHist.create(vehicleVO));
	}
}
