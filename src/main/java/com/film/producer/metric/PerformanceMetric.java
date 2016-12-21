package com.film.producer.metric;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

@Aspect
public class PerformanceMetric {

    @Pointcut("execution(* com.film.producer.controller..*(..))")
    public void methodToCalculateMetric() {}

    @Before("methodToCalculateMetric()")
    public void beforeCallMethod(final JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("Before calling controller method: " + method.getName());
    }


    @Around("methodToCalculateMetric()")
    public Object profile(final ProceedingJoinPoint joinPoint) throws Throwable {
        final MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        final Method method = signature.getMethod();

        final long start = System.currentTimeMillis();
        final Object output = joinPoint.proceed();

        final long elapsedTime = System.currentTimeMillis() - start;
        System.out.println(method.getName() + " method execution time: " + elapsedTime + " milliseconds.");
        return output;
    }
}
