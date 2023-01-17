package com.example.hello.aop;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect //Aop를 정의하는 클래스에 할당
@Component
public class ParameterAop  {

    //pointcut : aop를 적용 시킬 지점을 설정
    @Pointcut("execution(* com.example.hello.controller..*.*(..))")
    private void cut(){}

    @Before("cut()")
    public void before(JoinPoint joinpoint){
        Object[] args = joinpoint.getArgs();
        for(Object obj : args){
            System.out.println("type : " + obj.getClass().getSimpleName());
            System.out.println("value : " + obj);
        }
    }

    @AfterReturning(value = "cut()", returning = "returnObj")
    public void afterReturn(JoinPoint joinPoint, Object returnObj){
        System.out.println(returnObj);
    }
}
