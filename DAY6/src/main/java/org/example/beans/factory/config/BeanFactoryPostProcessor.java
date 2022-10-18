package org.example.beans.factory.config;

import org.example.beans.BeansException;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName BeanFactoryPostProcessor.java
 * @Description 可以在所有的 BeanDefinition 加载完成后，实例化 Bean 对象之前，修改 BeanDefinition 属性
 * @createTime 2022/10/18
 */
public interface BeanFactoryPostProcessor {
    void postProcessorBeanFactory(ConfigurableBeanFactory beanFactory) throws BeansException;
}
