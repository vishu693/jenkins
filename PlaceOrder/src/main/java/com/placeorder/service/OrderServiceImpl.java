package com.placeorder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.placeorder.kafka.KafkaProducer;
import com.placeorder.model.Inventory;
import com.placeorder.model.PlaceOrder;
import com.placeorder.model.UserAccount;
import com.placeorder.repository.PlaceorderRepo;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private PlaceorderRepo placeorderRepo;
	
	@Autowired
    private RestTemplate restTemplate;
	
	@Autowired
    private KafkaProducer kafkaProducer;
	
	
	
	

	@Override
	public Long getInventory(String name) {
	
		System.out.println("namenamenamename="+name);
		  return restTemplate.getForObject("http://my-gateway/mysearch/get/{skuName}", Long.class, name);
	}

	@Override
	public UserAccount getUser(UserAccount user) {
		user.setLocation("hello");
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<UserAccount> request = new HttpEntity<>(user, headers);
		
		
		System.out.println("request="+request);
		return  restTemplate.postForObject("http://my-gateway/myaccount/getuserDetail", request, UserAccount.class);
		
	
	}

	@Override
	public int save(PlaceOrder order) {
		 placeorderRepo.save(order);
		 return order.getOrderId();
	}
	
	
	
	
	

		@Override
		public Integer updateInventory(Inventory inventory) {
			HttpHeaders headers=new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			
			 HttpEntity<Inventory> request = new HttpEntity<Inventory>(inventory, headers);
			 return restTemplate.postForObject("http://MY-GATEWAY/mysearch/update", request,Integer.class);
			
			 
		}

		@Override
		public void publishOnQueue(PlaceOrder prder) {
			try {
				kafkaProducer.sendOrderDetail(prder);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

}
