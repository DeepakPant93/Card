package com.cards.card.aspect;

import com.cards.card.context.CardContext;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

/**
 *
 * @author suraj.singh
 */
@Aspect
@Component
@Slf4j
@AllArgsConstructor
public class HeaderAspect {

    private static final String LOGS = "{} - User Id {} received.";
    private static final String USER_ID = "userId";

    private final WebRequest request;

    @Before("execution(* com.cards.card.controller.*.*(..))")
    public void beforeController(JoinPoint joinPoint) {
        String userId = request.getHeader(USER_ID);
        log.info(LOGS, joinPoint, userId);

        userId = Objects.nonNull(userId) ? userId : "";
        CardContext.setUserId(userId);
    }

    @After("execution(* com.cards.card.controller.*.*(..))")
    public void afterController(JoinPoint joinPoint) {
        CardContext.clear();
    }
}
