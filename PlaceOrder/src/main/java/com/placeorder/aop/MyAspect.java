package com.placeorder.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
	
	@Pointcut("@annotation(MyLogService)")
	public void pointCut()
	{
		
	}
	
	 @AfterThrowing("pointCut()")  
	public void error(JoinPoint jointPoint)
	{
		try {
       	 System.out.println("Error:....."+System.currentTimeMillis());
		}catch (Throwable e1) {
		}
	}
	 
	// @Before("pointCut()") 
	 @Around("pointCut()")  
	public void loggingAround(ProceedingJoinPoint joinPoint)throws Throwable 
	{
		try {
       	 System.out.println("Before: Method end at ....."+System.currentTimeMillis());
       	 joinPoint.proceed();
		}catch (Throwable e) {
			
			e.printStackTrace();
		}
		 
	}

}
