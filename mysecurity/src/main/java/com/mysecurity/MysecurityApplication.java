package com.mysecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MysecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(MysecurityApplication.class, args);
	}
	
	/*
	 * @Bean public AlwaysSampler defaultSampler() { return new AlwaysSampler(); }
	 */

}
