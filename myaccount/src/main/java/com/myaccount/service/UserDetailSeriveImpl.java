package com.myaccount.service;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myaccount.model.UserAccount;
import com.myaccount.repository.MyAccountRepository;
@Service
public class UserDetailSeriveImpl implements UserDetailService{
	
	@Autowired
	private MyAccountRepository myAccountRepository;

	private static final Logger logger = LogManager.getRootLogger();
	
	//@MyLogService 
	@Override
	public UserAccount findUser(Integer id) {
		
		logger.info("Fetching user details for "+id);
		
		Optional<UserAccount> userAcc= myAccountRepository.findById(id);
		if(userAcc.isPresent())
		{
			logger.info("User found for "+id);
			return userAcc.get();
		}else
			return null;
		
	}
	//@MyLogService 
	@Override
	public int save(UserAccount user) {
		
		logger.info("Ready to save user details ");
		myAccountRepository.save(user);
		return user.getAccountId();
	}
	
	

}
