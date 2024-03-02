package com.placeorder.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.placeorder.advice.InventoryNotFound;
import com.placeorder.advice.UserNotExists;
import com.placeorder.model.Inventory;
import com.placeorder.model.PlaceOrder;
import com.placeorder.model.UserAccount;
import com.placeorder.service.OrderService;
@RefreshScope
@RestController
@RequestMapping("/myplaceorder")
public class PlaceOrderController {
	//Logger logger=LoggerFactory.getLogger(PlaceOrderController.class);
	private static final Logger logger = LogManager.getRootLogger();
	
	
	@Autowired
	OrderService orderService;
	
	@PostMapping(value="/order")
	public void placing(@RequestBody PlaceOrder placeOrder)
	{
		
		logger.info("placeorder - order controller called...");
		
		UserAccount user=new UserAccount();
		
		user.setAccountId(placeOrder.getAccountId());
		user.setLocation("");
		user.setUserName(placeOrder.getUserName());
		
	
		Long availability=orderService.getInventory(placeOrder.getInventoryName());
		
		logger.info("placeorder - order controller called with value "+availability);
		
		if(availability<0)
			throw new InventoryNotFound(placeOrder.getInventoryName());
		
		logger.info("placeorder - Ready to call user details");
		
		
		UserAccount userObj= orderService.getUser(user);
		
		
		
		if(userObj==null)
			throw new UserNotExists(placeOrder.getUserName());
		
		logger.info("placeorder - User found successfully and ready to save ");
		
		
		
		orderService.save(placeOrder);
		
		try {
			
			logger.info("placeorder - Ready to publish on queue");
			
			
			orderService.publishOnQueue(placeOrder);
			logger.info("placeorder -  published on queue");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Inventory inventory=new Inventory();
		inventory.setInventoryName(placeOrder.getInventoryName());
		inventory.setInventoryId(placeOrder.getInventoryId());
		
		logger.info("placeorder - updateInventory called ");
		Integer aavailable=orderService.updateInventory(inventory);
		if(aavailable<1)
			logger.info("placeorder -  not available for update inventory");
		
		
	}
	
	

}
