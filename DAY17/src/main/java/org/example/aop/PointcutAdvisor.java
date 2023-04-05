package org.example.aop;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName PointcutAdvisor.java
 * @Description TODO
 * @createTime 2022/11/27
 */
public interface PointcutAdvisor extends Advisor {
    Pointcut getPointcut();
}
