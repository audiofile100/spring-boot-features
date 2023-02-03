package com.springbootfeatures.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Aspect
@Configuration
public class LoggingAspect {

    @Before("com.springbootfeatures.aspect.pointcut.PointCuts.ALL()")
    public void before(JoinPoint joinPoint) {

        log.info("BEFORE {}", joinPoint);
    }

    @After("com.springbootfeatures.aspect.pointcut.PointCuts.ALL()")
    public void after(JoinPoint joinPoint) {

        log.info("AFTER {}", joinPoint);
    }

    @AfterReturning("com.springbootfeatures.aspect.pointcut.PointCuts.ALL()")
    public void afterReturning(JoinPoint joinPoint) {

        log.info("AFTER RETURNING {}", joinPoint);
    }

    @AfterThrowing("com.springbootfeatures.aspect.pointcut.PointCuts.ALL()")
    public void afterThrowing(JoinPoint joinPoint) {

        log.info("AFTER THROWING {}", joinPoint);
    }

    @Around("com.springbootfeatures.aspect.pointcut.PointCuts.SERVICES()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        long start = System.currentTimeMillis();

        Object obj = proceedingJoinPoint.proceed();  // execute the method

        long elapsed = System.currentTimeMillis() - start;

        log.info("ELAPSED TIME: {} ms for {}", elapsed, proceedingJoinPoint);
        log.info("OBJECT: {}", obj);

        return obj;
    }
}
