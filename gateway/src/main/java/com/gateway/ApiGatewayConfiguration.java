package com.gateway;


import java.time.Duration;

import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
//https://www.youtube.com/watch?v=aULsajc6da8	
//https://www.youtube.com/watch?v=5eAQLygfmbg
//https://www.baeldung.com/spring-cloud-gateway-rate-limit-by-client-ip
//https://medium.com/bliblidotcom-techblog/spring-cloud-gateway-custom-api-limiter-1a600de6bedf


@Configuration
public class ApiGatewayConfiguration {
	
/*	
	@Bean
	public RedisRateLimiter redisRateLimiter()
	{
		return new RedisRateLimiter(10, 20);
	}
	
	*/
	
	//private final AuthenticationFilter filter;

	
	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		
		
		return builder.routes()
				
				.route(p->p.path("/myaccount/**")
						.uri("lb://my-account"))
				
				.route(p->p.path("/mysearch/**")
						.uri("lb://my-search"))
				
				.route(p->p.path("/myplaceorder/**")
						.uri("lb://my-placeorder"))
				
				/*		.route(p->p.path("/myaccount/**")
				.filters(f->f.circuitBreaker(c->c.setName("MyaccountCircuitBreaker").setFallbackUri("/my-account-fallback")))
				.uri("lb://my-account"))
				
		.route(p->p.path("/myaccount/**")
						.filters(f->f.requestRateLimiter().configure(c->c.setRateLimiter(redisRateLimiter())))
						.uri("lb://my-account"))
				
				*/
				
				.build();
				
				
				
			
	}
	@Bean
	public Customizer<Resilience4JCircuitBreakerFactory> defaultCustomizer()
	{
		return factory->factory.configureDefault(id->new Resilience4JConfigBuilder(id).
				circuitBreakerConfig(CircuitBreakerConfig.ofDefaults())
				.timeLimiterConfig(TimeLimiterConfig.custom().timeoutDuration(Duration.ofSeconds(2)).build()).build());
	}

}
