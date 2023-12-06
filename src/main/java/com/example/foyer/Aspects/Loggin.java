package com.example.foyer.Aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Slf4j
@Component
public class Loggin {
    @Before("execution( * com.example.foyer.service.*.*(..))")
    public void StartOfMethod(JoinPoint joinPoint)
    {
        String name = joinPoint.getSignature().getName();

        log.info(" the method " + name +"started ");

    }
    @AfterReturning("execution( * com.example.foyer.service.*.*(..))")
    public void EndOfMethod(JoinPoint joinPoint)
    {
        String name = joinPoint.getSignature().getName();

        log.info("out of method " + name );

    }
    @Around("execution(public * com.example.foyer.service.*.*(..)))")
    public Object CountExecutionTime(ProceedingJoinPoint pjp ) throws Throwable {
        StopWatch stopWatch  = new StopWatch();
        stopWatch.start();
        Object o = pjp.proceed();
        stopWatch.stop();
        String methodName = pjp.getSignature().getName();
        log.info("The runtime of the method ( {} ) =  {} ",methodName,stopWatch.getTotalTimeMillis());
        return o;

    }

}
