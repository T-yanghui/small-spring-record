package org.example.beans.factory.support;


import org.example.beans.BeansException;
import org.example.beans.factory.config.BeanDefinition;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName BeanDefinitionRegistry.java
 * @Description TODO
 * @createTime 2022/10/09
 */
public interface BeanDefinitionRegistry {
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    BeanDefinition getBeanDefinition(String name) throws BeansException;

    boolean containsBeanDefinition(String name);

    String[] getBeanDefinitionNames();
}
