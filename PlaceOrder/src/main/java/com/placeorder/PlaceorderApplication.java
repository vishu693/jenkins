package com.placeorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@RefreshScope
@SpringBootApplication
@EnableDiscoveryClient
public class PlaceorderApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlaceorderApplication.class, args);
	}
	/*
	 * @Bean public AlwaysSampler defaultSampler() { return new AlwaysSampler(); }
	 */
	
	
	
}
