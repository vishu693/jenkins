package com.mycaching.controller;

import java.time.LocalDateTime;

import org.springframework.cache.annotation.CacheConfig;

@CacheConfig(cacheNames={"addresses"})  
public class Employee {
	
	int val;
	String name;
	LocalDateTime time;
	
	
	
	
	public Employee(int val, String name) {
		super();
		this.val = val;
		this.name = name;
		this.time=LocalDateTime.now();
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
