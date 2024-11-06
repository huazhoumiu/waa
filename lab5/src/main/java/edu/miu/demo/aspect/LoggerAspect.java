package edu.miu.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {
    @Pointcut("@annotation(edu.miu.demo.aspect.annotation.LogMe)")
    public void logMePointcut() {

    }

    @Pointcut("execution(* edu.miu.demo.controller.UserController.*(..))")
    public void logMe(){

    }

    @Before("logMe()")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Log before the method: " + joinPoint.getSignature().getName());
    }

    @After("logMe()")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("Log after the method: " + joinPoint.getSignature().getName());
    }

    @AfterReturning("logMe()")
    public void logAfterReturning(JoinPoint joinPoint) {
        System.out.println("Log after returned the method: " + joinPoint.getSignature().getName());
    }

    @AfterThrowing("logMe()")
    public void logAfterThrowing(JoinPoint joinPoint) {
        System.out.println("Log after throwing the method: " + joinPoint.getSignature().getName());
    }
}
