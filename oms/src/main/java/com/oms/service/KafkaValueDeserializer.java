package com.oms.service;

import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oms.model.PlaceOrder;

public class KafkaValueDeserializer implements Deserializer<PlaceOrder>{
	
	 private ObjectMapper objectMapper = new ObjectMapper();
		
		@Override
	    public void configure(Map<String, ?> configs, boolean isKey)
	    {
	        
	    }

		 @Override
		    public PlaceOrder deserialize(String topic, byte[] data) {
		        try {
		            return objectMapper.readValue(new String(data, "UTF-8"), PlaceOrder.class);
		        } catch (Exception e) {
		           e.printStackTrace();
		            return null;
		        }
		    }

	@Override
    public void close() {
    }
	
}
