package org.example.aop;


import java.lang.reflect.Method;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName MethodBeforeAdvice.java
 * @Description TODO
 * @createTime 2022/11/27
 */
public interface MethodBeforeAdvice extends BeforeAdvice {
    void before(Method method, Object[] args, Object target) throws Throwable;
}
