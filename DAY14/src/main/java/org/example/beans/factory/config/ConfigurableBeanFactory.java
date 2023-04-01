package org.example.beans.factory.config;

import org.example.beans.factory.HierarchicalBeanFactory;
import org.example.util.StringValueResolver;

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
    void destroySingletons();
    void addEmbeddedResolver(StringValueResolver valueResolver);
    String resolveEmbeddedValue(String value);
}
