package com.myaccount.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myaccount.model.UserAccount;

@Repository
public  interface MyAccountRepository extends JpaRepository<UserAccount, Integer>{
	
	

}
