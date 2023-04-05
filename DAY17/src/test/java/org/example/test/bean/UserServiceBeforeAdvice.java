package org.example.test.bean;

import org.example.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName UserServiceBeforeAdvice.java
 * @Description TODO
 * @createTime 2023/04/03
 */
public class UserServiceBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("BeforeAdvice "+method.getName());
    }
}
