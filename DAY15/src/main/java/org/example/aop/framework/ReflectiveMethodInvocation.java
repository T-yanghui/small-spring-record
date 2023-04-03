package org.example.aop.framework;

import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName ReflectiveMethodInvocation.java
 * @Description TODO
 * @createTime 2022/11/08
 */
public class ReflectiveMethodInvocation implements MethodInvocation {
    //target object
    protected final Object target;
    protected final Method method;
    protected final Object[] args;

    public ReflectiveMethodInvocation(Object target, Method method, Object[] args) {
        this.target = target;
        this.method = method;
        this.args = args;
    }

    @Override
    public Method getMethod() {
        return this.method;
    }

    @Override
    public Object[] getArguments() {
        return args;
    }

    @Override
    public Object proceed() throws Throwable {
        return method.invoke(target, args);
    }

    @Override
    public Object getThis() {
        return target;
    }

    @Override
    public AccessibleObject getStaticPart() {
        return method;
    }
}
