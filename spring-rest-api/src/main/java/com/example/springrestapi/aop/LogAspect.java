package com.example.springrestapi.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LogAspect {
    private static final String DASH = "/";

    @Pointcut(value = "execution(* com.example.demo.api.*.*(..))")
    public void api() {
    }

    //    @Around(value = "@annotation(com.example.demo.annotation.Logging)")
//    @Around("execution(* com.example.demo.api.*.*(..))")
    @Around("api()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        String declaringTypeName = joinPoint.getSignature().getDeclaringTypeName();
        String signatureName = joinPoint.getSignature().getName();

        log.info("[METHOD CALL]" + declaringTypeName + DASH + signatureName);
        return joinPoint.proceed();
    }

    @AfterThrowing(value = "api()", throwing = "e")
    public void afterThrowingAspect(Throwable e) {
        log.error("[ERROR]: " + e.getMessage());
    }
}
