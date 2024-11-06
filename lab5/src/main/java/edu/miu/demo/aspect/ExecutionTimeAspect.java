package edu.miu.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeAspect {
    @Pointcut("@annotation(edu.miu.demo.aspect.annotation.ExecutionTime)")
    public void executionTimePointcut() {

    }

    @Around("executionTimePointcut()")
    public Object executionTimeAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.nanoTime();
        Object result = joinPoint.proceed();
        long endTime = System.nanoTime();
        System.out.println("Execution time of " + joinPoint.getSignature().getName() + ": " + (endTime - startTime) + "ns");
        return result;
    }
}
