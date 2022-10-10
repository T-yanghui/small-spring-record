package spring.factory.support;

import spring.factory.config.SingletonBeanRegistry;

import java.util.HashMap;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName DefaultSingletonRegistry.java
 * @Description TODO
 * @createTime 2022/10/09
 */
public class DefaultSingletonRegistry implements SingletonBeanRegistry {
    private final HashMap<String, Object> singletonObjects = new HashMap<String, Object>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    public void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }
}
