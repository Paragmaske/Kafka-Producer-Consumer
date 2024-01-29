package com.kafkaproducer.Producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.kafkaproducer.Model.Emp;

@RestController
public class KafkaaProducer {
	@Autowired
	KafkaTemplate kafkaTemplate;
    private static final String TOPIC = "myfirsttopic";

    private final ObjectMapper objectMapper = new ObjectMapper();

	@PostMapping("/produce")
	public void  produceOnKafka(@RequestBody Emp emp) throws JsonProcessingException
	{
        byte[] empBytes = objectMapper.writeValueAsBytes(emp);

		kafkaTemplate.send(TOPIC,"hello",empBytes);
	}

}
