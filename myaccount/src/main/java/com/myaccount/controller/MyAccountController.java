package com.myaccount.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myaccount.advice.UserAlreadyExists;
import com.myaccount.advice.UserNotExists;
import com.myaccount.model.UserAccount;
import com.myaccount.service.UserDetailService;
//@RefreshScope
@RestController
@RequestMapping("/myaccount")
public class MyAccountController {
	
	//Logger logger=LoggerFactory.getLogger(MyAccountController.class);
	//private static final Logger LOG = LoggerFactory.getLogger(MyAccountController.class.getName());
	private static final Logger logger = LogManager.getRootLogger();
	
	@Autowired
	private UserDetailService userDetailService;
	
	@Value("${prop.prop}")
	private String myVal;
	
	@Value("${my.loadtest}")
	private String loadtest;
	
	
	@PostMapping(value = "/signup")
	public UserAccount singup(@RequestBody UserAccount userAccount)
	{
		
		logger.info("myAccount - signup controller called...");
		
		UserAccount user=userDetailService.findUser(userAccount.getAccountId());
			if(user==null )
			{
				logger.info("User "+userAccount+" not found , So Starting sining up....." );
					userDetailService.save(userAccount);
					logger.info("User "+userAccount+" is signed up successfully ..." );
				
			}else
			{
				logger.info("User "+userAccount+" already exists in the system....." );
				throw new UserAlreadyExists(userAccount.getUserName());
			}
		
			return userAccount;
		
	}
	
	@PostMapping(value = "/login")
	public boolean login (@RequestBody UserAccount userAccount)
	{
	
		logger.info("myAccount - login controller called...");
		UserAccount user=userDetailService.findUser(userAccount.getAccountId());
	
		if(user==null)
		{
			logger.info("User "+userAccount+" not found in the system....." );
			throw new UserNotExists(userAccount.getUserName());
		}else
		{
			if(user.getPassword().equals(userAccount.getPassword()))
			{
				logger.info(userAccount.getUserName()+" login sucessfully...." );
				return true;
			}
			else
				throw new UserNotExists(userAccount.getUserName());
		}
		
		
	}
	
	@PostMapping(value="/getuserDetail")
	public UserAccount getDetails (@RequestBody UserAccount userAccount)
	{
		logger.info("myAccount - getuserDetail controller called...");
		UserAccount user=userDetailService.findUser(userAccount.getAccountId());
		
		if(user==null)
		{
			logger.info("User "+userAccount+" not found in the system....." );
			throw new UserNotExists(userAccount.getUserName());
		}else
		{
			return userAccount;
			
		}
		
		
		
		
		
	}
	
	@GetMapping(value="/verify")
	public String getSample (@RequestBody UserAccount userAccount)
	{
		logger.info("myAccount - sample controller called...");
		return myVal;
		
	}
	
	@GetMapping(value="/loadtest")
	public String getSample ()
	{
		logger.info("Request is coming for "+loadtest);
		return loadtest;
		
	}
	

/*	@GetMapping(value="/getuserDetail")
	public String getDetailsViaget (@RequestBody UserAccount userAccount)
	{
		
		System.out.println("userAccount==="+userAccount);
		UserAccount user=userDetailService.findUser(userAccount.getAccountId());
		
		if(user==null)
		{
			logger.info("User "+userAccount+" not found in the system....." );
			throw new UserNotExists(userAccount.getUserName());
		}else
		{
			if(user.getPassword().equals(userAccount.getPassword()))
			return userAccount.getUserName();
			else
				throw new UserNotExists(userAccount.getUserName());
		}
		
		
	}
	*/
	

}
