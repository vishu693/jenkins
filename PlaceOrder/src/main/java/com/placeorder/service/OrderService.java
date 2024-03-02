package com.placeorder.service;

import org.springframework.stereotype.Service;

import com.placeorder.model.Inventory;
import com.placeorder.model.PlaceOrder;
import com.placeorder.model.UserAccount;

@Service
public interface OrderService {
	
	public Long getInventory(String name);
	public UserAccount getUser(UserAccount name);
	int save(PlaceOrder prder);
	Integer updateInventory(Inventory inventory);
	void publishOnQueue(PlaceOrder prder);
	
}
