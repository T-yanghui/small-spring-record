package org.example.aop.framework;

import org.example.aop.AdvisedSupport;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName ProxyFactory.java
 * @Description TODO
 * @createTime 2022/11/28
 */
public class ProxyFactory {
    private AdvisedSupport advisedSupport;

    public ProxyFactory(AdvisedSupport advisedSupport) {
        this.advisedSupport = advisedSupport;
    }

    public Object getProxy() {
        return createAopProxy().getProxy();
    }

    private AopProxy createAopProxy() {
        return advisedSupport.isProxyTargetClass() ? new Cglib2AopProxy(advisedSupport) : new JdkDynamicAopProxy(advisedSupport);
    }
}
