package com.placeorder.advice;

public class UserNotExists extends RuntimeException{
	
	public UserNotExists(String user)
	{
		super("User not found "+user);
	}

}
