package com.oms.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.oms.model.PlaceOrder;

@Service
public class KafkaConsumer {
	
	private static final Logger logger=LoggerFactory.getLogger(KafkaConsumer.class);
	

	@KafkaListener(topics ="wikkipedia",groupId ="myGroup")
	public void consume(PlaceOrder message )
	{
		
		logger.info("Consume json message is "+message);
	
	}
	

}
