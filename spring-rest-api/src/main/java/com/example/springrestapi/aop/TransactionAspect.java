package com.example.springrestapi.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class TransactionAspect {

    @Around("@annotation(org.springframework.transaction.annotation.Transactional)")
    public Object handleTransactionAspect(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();

        //todo: handle transaction
        return joinPoint.proceed();

    }
}
