package org.example.beans.factory.support.beans;

import com.google.common.base.Stopwatch;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.time.Duration;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName UserServiceIntercepter.java
 * @Description TODO
 * @createTime 2022/11/08
 */
public class UserServiceIntercepter implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Stopwatch stopwatch = Stopwatch.createStarted();
        try {
            return invocation.proceed();
        } finally {
            System.out.println("Monitor "+invocation.getMethod());
            System.out.println("cost time: "+stopwatch);
        }
    }
}
