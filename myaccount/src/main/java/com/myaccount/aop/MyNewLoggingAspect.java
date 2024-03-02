package com.myaccount.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(1)
@Component
public class MyNewLoggingAspect {
	private static final Logger logger = LogManager.getRootLogger();
	
	@Before(value = "execution(* com.myaccount.controller..*(..))")
	public void loggingStats(JoinPoint joinPoint)
	{
		logger.info("before log called....");
	}
	
}
