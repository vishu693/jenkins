package com.placeorder.kafka;

import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.placeorder.model.PlaceOrder;

public class MyValueSerializer implements Serializer<PlaceOrder>{
	
	 private ObjectMapper objectMapper = new ObjectMapper();
	
	@Override
    public void configure(Map<String, ?> configs, boolean isKey)
    {
        
    }

	@Override
	public byte[] serialize(String topic, PlaceOrder data) {
	
		if(data==null)
			return null;
		
		 try {
	            return objectMapper.writeValueAsBytes(data);
	        } catch (JsonProcessingException e) {
	            
	           e.printStackTrace();
	            return null;
	        }
		
	}
	
	@Override
    public void close() {
    }

	
	
}
