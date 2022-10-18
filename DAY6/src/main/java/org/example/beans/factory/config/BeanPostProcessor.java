package org.example.beans.factory.config;

import org.example.beans.BeansException;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName BeanPostProcessor.java
 * @Description Factory hook that allows for custom modification of new bean instances,
 * checking for marker interfaces or wrapping them with proxies.
 * @createTime 2022/10/18
 */
public interface BeanPostProcessor {
    Object postProcessorBeforeInitialization(Object bean, String beanName) throws BeansException;

    Object postProcessorAfterInitialization(Object bean, String beanName) throws BeansException;
}
