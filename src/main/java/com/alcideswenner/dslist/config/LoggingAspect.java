package com.alcideswenner.dslist.config;

import java.util.Arrays;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class LoggingAspect {

    @Around("@within(com.alcideswenner.dslist.annotations.LogExecution) && execution(* *(..))")
    public Object logExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object[] args = joinPoint.getArgs();
        Object proceed = joinPoint.proceed();

        stopWatch.stop();
        System.out.println(
                joinPoint.getSignature().toString().concat(" executado em: " + stopWatch.getTotalTimeMillis() 
                + " ms "+Arrays.toString(args)));

        return proceed;
    }
}