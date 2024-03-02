package com.search.service;

import com.search.model.Inventory;

public interface InventoryInterface {
	
	Inventory findUser(String name);
	
	Inventory updateInventory(Inventory inventory);

}
