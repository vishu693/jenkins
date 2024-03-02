package com.mycaching.controller;

import java.time.LocalDateTime;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//https://www.baeldung.com/spring-cache-tutorial

//https://spring.io/guides/gs/caching


//https://www.javatpoint.com/spring-boot-caching

//https://www.youtube.com/watch?v=Pj8Q_9dovgY&list=PLq3uEqRnr_2HY6LMQsbvsK4btj51sWhBS&index=2

//https://www.youtube.com/watch?v=MwmnFGYSOPk

@RestController
@RequestMapping("/mycaching")
public class MyController {
	
	@GetMapping(value="/test")
	//@Cacheable(value="addresses")
	//@CacheEvict(value="addresses", allEntries=true)
	@CachePut(value="addresses")
	public Employee getValue()
	{
		System.out.println("getValue  is called....");
		
		return getDate();
		
	}
	
	//@CacheEvict(value="addresses", allEntries=true)
	//@CachePut(value="addresses")
	//@Cacheable(value = "addresses", key = "#customer.name")
	public static Employee getDate()
	{
		System.out.println("getDate  is called....");
		
			return new Employee(1, "111111111");
			
		
	}
	
	

}
