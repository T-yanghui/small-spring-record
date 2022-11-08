package org.example.aop;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName TargetSource.java
 * @Description 被代理的目标对象
 * @createTime 2022/11/08
 */
public class TargetSource {
    private final Object target;

    public TargetSource(Object target) {
        this.target = target;
    }

    public Class<?>[] getTargetClass() {
        return target.getClass().getInterfaces();
    }

    public Object getTarget() {
        return target;
    }
}
