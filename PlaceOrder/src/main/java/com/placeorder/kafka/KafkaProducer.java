package com.placeorder.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.placeorder.model.PlaceOrder;

@Service
public class KafkaProducer {
	
	@Autowired
	private KafkaTemplate<String, PlaceOrder> kafkaTemplate;

	public KafkaProducer(KafkaTemplate<String, PlaceOrder> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}
	
	
	public void sendOrderDetail(PlaceOrder placeOrder) throws InterruptedException
	{
		
		String topicName="wikkipedia";
		kafkaTemplate.send(topicName, placeOrder);
		
		System.out.println("Message sent successfully......."+placeOrder);
		
	}

}
