package com.myaccount.service;

import org.springframework.stereotype.Service;

import com.myaccount.model.UserAccount;

@Service
public interface UserDetailService {
	
	UserAccount findUser(Integer id);
	int save(UserAccount user);

}
