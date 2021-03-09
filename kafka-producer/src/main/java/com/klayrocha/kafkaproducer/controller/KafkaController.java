package com.klayrocha.kafkaproducer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klayrocha.kafkaproducer.producer.TopicProducer;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {
	
	private final TopicProducer topicProducer;

	@GetMapping(value = "/send")
	public void send() {
		topicProducer.send("Mensagem de teste enviada ao tópico");
	}
}
