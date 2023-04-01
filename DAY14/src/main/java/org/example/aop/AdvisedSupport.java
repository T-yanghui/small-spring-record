package org.example.aop;


import org.aopalliance.intercept.MethodInterceptor;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName AdvisedSupport.java
 * @Description TODO
 * @createTime 2022/11/08
 */
public class AdvisedSupport {
    private TargetSource targetSource;
    private MethodMatcher methodMatcher;
    private MethodInterceptor methodInterceptor;
    private boolean proxyTargetClass = false;

    public boolean isProxyTargetClass() {
        return proxyTargetClass;
    }

    public void setProxyTargetClass(boolean proxyTargetClass) {
        this.proxyTargetClass = proxyTargetClass;
    }

    public MethodInterceptor getMethodInterceptor() {
        return methodInterceptor;
    }

    public void setMethodInterceptor(MethodInterceptor methodInterceptor) {
        this.methodInterceptor = methodInterceptor;
    }

    public TargetSource getTargetSource() {
        return targetSource;
    }

    public void setTargetSource(TargetSource targetSource) {
        this.targetSource = targetSource;
    }

    public MethodMatcher getMethodMatcher() {
        return methodMatcher;
    }

    public void setMethodMatcher(MethodMatcher methodMatcher) {
        this.methodMatcher = methodMatcher;
    }
}
