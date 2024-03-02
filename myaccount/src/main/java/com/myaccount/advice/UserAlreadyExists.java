package com.myaccount.advice;

public class UserAlreadyExists extends RuntimeException{
	
	public UserAlreadyExists(String user)
	{
		super("User already  found "+user);
	}

}
