package com.myaccount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@RefreshScope
//@EnableDiscoveryClient
//@CrossOrigin
@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class MyaccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyaccountApplication.class, args);
	}
	
	/*
	 * @Bean public AlwaysSampler defaultSampler() { return new AlwaysSampler(); }
	 */

}
