package com.placeorder.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyRest {
	
	@LoadBalanced
    @Bean
    public RestTemplate restTesmplate() {
        return new RestTemplate();
    }

}
