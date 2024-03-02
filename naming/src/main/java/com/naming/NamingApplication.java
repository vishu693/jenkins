package com.naming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
@RefreshScope
@EnableEurekaServer
@SpringBootApplication
public class NamingApplication {

	public static void main(String[] args) {
		SpringApplication.run(NamingApplication.class, args);
	}

}
