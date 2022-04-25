package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author liuLiang
 * @create 2022/4/8 21:11
 * @email kekorand@gmail.com
 * @Description
 */
@Aspect
@Component
public class AspectUser {

    @Pointcut("execution(* com.example.demo.controller.UserController.getUser(Integer))")
    public void sayHelloPointcut(){

    }
    @After(value = "sayHelloPointcut()")
    public void sayHelloAfter(JoinPoint joinPoint){
        System.out.println("After--UserController.getUser:hello");
    }

    @Before(value = "sayHelloPointcut()")
    public void sayHelloBefore(JoinPoint joinPoint){
        System.out.println("Before--UserController.getUser:hello");
    }

    @Around(value = "sayHelloPointcut()")
    public Object sayHelloAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("AroundBefore--UserController.getUser:hello");
        Object proceed = pjp.proceed();
        System.out.println("AroundAfter--UserController.getUser:hello");
        return proceed;
    }
    @AfterReturning(value = "sayHelloPointcut()")
    public void sayHelloAfterReturning(JoinPoint joinPoint){
        System.out.println("AfterReturning--UserController.getUser:hello");
    }
}
