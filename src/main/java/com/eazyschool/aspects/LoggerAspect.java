package com.eazyschool.aspects;

import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class LoggerAspect {
	
	
		@Around("execution(* com.eazyschool..*.*(..))")
	
	public Object log(ProceedingJoinPoint jointPoint) throws Throwable{
		log.info(jointPoint.getSignature().toString()+" method execution start");
		Instant start = Instant.now();
		Object returnObj = jointPoint.proceed();
		Instant finish = Instant.now();
		Long timeElapsed =  Duration.between(start, finish).toMillis();
		log.info("Time took to execute : "+jointPoint.getSignature().toString()+" method is : "+timeElapsed);
		log.info(jointPoint.getSignature().toString()+ "method execution ends");
		return returnObj;
		
	}
		
		@AfterThrowing(value = "execution(* com.eazyschool.*.*(..))",throwing="ex")
		public void logException(JoinPoint jointPoint, Exception ex) {
			log.error(jointPoint.getSignature()+"An exception happened due to : "+ex.getMessage());
			
		}
	

}

