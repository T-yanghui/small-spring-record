package org.example.beans.factory.config;

import org.example.beans.factory.HierarchicalBeanFactory;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName ConfigurableBeanFactory.java
 * @Description TODO
 * @createTime 2022/10/13
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {
    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
