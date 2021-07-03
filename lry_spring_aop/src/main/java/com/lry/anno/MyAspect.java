package com.lry.anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component("myAspect")
@Aspect //标注当前MyAspect是一个切面类
public class MyAspect {

    //配置前置通知
    //@Before("execution(* com.lry.anno.*.*(..))")
    public void before() {
        System.out.println("前置增强。。。。。。");
    }

    public void afterRunning() {
        System.out.println("后置置增强。。。。。。");
    }

//    Proceeding JoinPoint: 正在执行的连接点 == 切点
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前增强。。。");
        // 切点方法
        Object proceed = pjp.proceed();
        System.out.println("环绕后增强。。。");
        return proceed;
    }

    public void afterThrowing() {
        System.out.println("异常抛出增强。。。。。。");
    }

    @After("MyAspect.pointcut()")
    public void after() {
        System.out.println("最终增强。。。。。。");
    }

    // 定义切点表达式
    @Pointcut("execution(* com.lry.anno.*.*(..))")
    public void pointcut() {}
}
