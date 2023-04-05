package org.example.aop;

import java.lang.reflect.Method;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName MethodMatcher.java
 * @Description TODO
 * @createTime 2022/11/07
 */
public interface MethodMatcher {
    /**
     * @title matches
     * @description Perform static checking whether the given method matches. If this whether or not this method matches statically
     */
    boolean matches(Method method,Class<?> clazz);
}
