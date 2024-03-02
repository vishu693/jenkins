package com.gateway;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	
	private static final Logger logger = LogManager.getRootLogger();
	
	
	@GetMapping(value="/my-account-fallback")
	public String getSample ()
	{
		logger.info("API GAteway Fallback method called ...");
		return "There were error while connection, PLease try after sometime...";
		
	}
	
	@GetMapping(value="/apisample")
	public String apiSample ()
	{
		logger.info("API Controller ...");
		return "API Controller ...";
		
	}

}
