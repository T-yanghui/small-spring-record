package org.example.aop.framework.adapter;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.example.aop.MethodBeforeAdvice;
import org.example.aop.MethodMatcher;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName MethodBeforeAdviceInterceptor.java
 * @Description TODO
 * @createTime 2022/11/27
 */
public class MethodBeforeAdviceInterceptor implements MethodInterceptor {
    private MethodBeforeAdvice advice;

    public MethodBeforeAdviceInterceptor() {
    }

    public MethodBeforeAdviceInterceptor(MethodBeforeAdvice advice) {
        this.advice = advice;
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        this.advice.before(invocation.getMethod(), invocation.getArguments(), invocation.getThis());
        return invocation.proceed();
    }

    public void setAdvice(MethodBeforeAdvice advice) {
        this.advice = advice;
    }
}
