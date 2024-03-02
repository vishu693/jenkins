package com.search.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.search.model.Inventory;
import com.search.repository.InvertoryRepo;

@Service
public class InventoryServiceImpl implements InventoryInterface{

	@Autowired
	private InvertoryRepo invertoryRepo ;
	
	@Override
	public Inventory findUser(String name) {
		
		return invertoryRepo.findByinventoryName(name);
	
	}

	@Override
	public Inventory updateInventory(Inventory inventory) {
		return invertoryRepo.save(inventory);
	}

}
