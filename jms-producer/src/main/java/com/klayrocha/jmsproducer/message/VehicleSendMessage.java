package com.klayrocha.jmsproducer.message;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.klayrocha.jmsproducer.vo.VehicleVO;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class VehicleSendMessage {

	@Value("${vehicle.rabbitmq.exchange}")
	String exchange;

	@Value("${vehicle.rabbitmq.routingkey}")
	String routingkey;

	private final RabbitTemplate rabbitTemplate;

	public void sendMessage(VehicleVO vehicleVO) {
		rabbitTemplate.convertAndSend(exchange, routingkey, vehicleVO);
	}
}
