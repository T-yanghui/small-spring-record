package org.example.aop;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName Pointcut.java
 * @Description TODO
 * @createTime 2022/11/07
 */
public interface Pointcut {
    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();
}
