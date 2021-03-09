package br.com.klayrocha.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class TopicListener {

	@KafkaListener(topics = "${topic.name}", groupId = "group_id")
	public void consume(ConsumerRecord<String, String> payload) {
		log.info("Order: {}", payload.value());
	}

}