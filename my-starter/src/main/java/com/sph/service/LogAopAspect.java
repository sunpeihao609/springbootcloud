package com.sph.service;

import com.sph.aop.LogClassFilter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunph
 * @Date: 2022/09/09/12:39
 * @Description:
 */
@Slf4j
//@Aspect
public class LogAopAspect implements PointcutAdvisor {

    @SneakyThrows
//    @Around("execution(public * *(..))")
    private Object log(MethodInvocation methodInvocation){
        String methodName = methodInvocation.getMethod().getName();
        Object[] arguments = methodInvocation.getArguments();
        String params = Arrays.toString(arguments);
        String clsName = methodInvocation.getThis().getClass().getName();
        String name = methodInvocation.getThis().getClass().getSimpleName();
        log.info("系统正在执行的类名:{},类的简单名称:{},方法:{},参数:{}",clsName,name,methodName,params);
        return methodInvocation.proceed();
    }

    @Override
    public Pointcut getPointcut() {
        return new Pointcut() {
            @Override
            public ClassFilter getClassFilter() {
                return new LogClassFilter();
            }

            @Override
            public MethodMatcher getMethodMatcher() {
                return new NameMatchMethodPointcut().addMethodName("*");
            }
        };
    }

    @Override
    public Advice getAdvice() {
        return (MethodInterceptor) this::log;
    }

    @Override
    public boolean isPerInstance() {
        return true;
    }
}
