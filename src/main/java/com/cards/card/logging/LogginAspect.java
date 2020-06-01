package com.cards.card.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Configuration
@Slf4j
public class LogginAspect {

	private static final String BEFORE_LOGS = "{} - Starts execution for the request.";
	private static final String AFTER_LOGS = "{} - Finished execution for the request.";

	@Before("execution(* com.cards.card.controller.*.*(..))")
	public void beforeController(JoinPoint joinPoint) {
		printLogs(BEFORE_LOGS, joinPoint);
	}

	@After(value = "execution(* com.cards.card.controller.*.*(..))")
	public void afterContrller(JoinPoint joinPoint) {
		printLogs(AFTER_LOGS, joinPoint);
	}

	@Before("execution(* com.cards.card.service.*.*(..))")
	public void beforeService(JoinPoint joinPoint) {
		printLogs(BEFORE_LOGS, joinPoint);
	}

	@After(value = "execution(* com.cards.card.service.*.*(..))")
	public void afterService(JoinPoint joinPoint) {
		printLogs(AFTER_LOGS, joinPoint);
	}

	private void printLogs(String message, JoinPoint joinPoint) {
		log.info(message, joinPoint.getSignature());
	}
}
