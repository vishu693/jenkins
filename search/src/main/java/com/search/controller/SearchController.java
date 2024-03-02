package com.search.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.search.advice.InventoryNotFound;
import com.search.model.Inventory;
import com.search.service.InventoryInterface;
@RefreshScope
@RestController
@RequestMapping("/mysearch")
public class SearchController {
	
	//Logger logger=LoggerFactory.getLogger(SearchController.class);
	
	private static final Logger logger = LogManager.getRootLogger();
	
	@Autowired
	InventoryInterface inventoryInterface;
	
	@GetMapping(value="/get/{skuName}")
	public long getInventory(@PathVariable String skuName)
	{
		logger.info("search - get controller called...");
		
		if(skuName==null)
			throw new InventoryNotFound(skuName);
		
		Inventory inventoryObj=	inventoryInterface.findUser(skuName);
		if(inventoryObj==null)
			throw new InventoryNotFound(skuName);
		
		logger.info("search - get controller returned value..."+inventoryObj.getAvailable());
		
		
		return inventoryObj.getAvailable();
	
	
	}
	
	@PostMapping(value="/update")
	public Integer updateInventory(@RequestBody Inventory inventory)
	{
		
		logger.info("search - update controller called...");
		
		if(inventory==null)
			throw new InventoryNotFound(null);
		
		Inventory inventoryObj=	inventoryInterface.findUser(inventory.getInventoryName());
		
		if(inventoryObj==null)
			throw new InventoryNotFound(inventory.getInventoryName());
		
		if(inventoryObj.getAvailable()<1)
			return -1;
		
		
		inventoryObj.setAvailable(inventoryObj.getAvailable()-1);
		inventoryObj.setConsumed(inventoryObj.getConsumed()+1);
		
		logger.info("search - updateInventory method called...");
		
		inventoryInterface.updateInventory(inventoryObj);
	
		return inventoryObj.getAvailable();
	
	
	}
	
	
	

}
