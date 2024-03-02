package com.placeorder.kafka;

import javax.xml.bind.ValidationEventHandler;

import org.springframework.kafka.core.KafkaTemplate;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;
import com.placeorder.model.PlaceOrder;

public class KafkaHandler implements EventHandler
{

	
	private String topic;
	
	private KafkaTemplate<String, PlaceOrder> kafkaTemplate;
	
	private PlaceOrder placeOrder;

	public KafkaHandler(String topic, KafkaTemplate<String, PlaceOrder> kafkaTemplate,PlaceOrder placeOrder) {
		super();
		this.topic = topic;
		this.kafkaTemplate = kafkaTemplate;
		this.placeOrder = placeOrder;
	}

	@Override
	public void onOpen() throws Exception {
	System.out.println("kafka open...");
		
	}

	@Override
	public void onClosed() throws Exception {
		
		System.out.println("kafka closed...");
	}

	@Override
	public void onMessage(String event, MessageEvent messageEvent) throws Exception {
		
		kafkaTemplate.send(topic, placeOrder);
	}

	@Override
	public void onComment(String comment) throws Exception {
		System.out.println("kafka comment..."+comment);
	}

	@Override
	public void onError(Throwable t) {
	
		System.out.println("kafka onError..."+t);
		
	}
	
}
