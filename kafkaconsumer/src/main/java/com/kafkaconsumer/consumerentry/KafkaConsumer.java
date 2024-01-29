package com.kafkaconsumer.consumerentry;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

	@KafkaListener(topics="myfirsttopic",groupId = "myfirstgroup")
	public void consume(ConsumerRecord<String, byte[]> record)
	{
	System.out.println("message received"+record.value());	
	}
}
