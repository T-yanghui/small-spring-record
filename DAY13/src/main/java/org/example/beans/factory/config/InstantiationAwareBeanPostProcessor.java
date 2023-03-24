package org.example.beans.factory.config;

import org.example.beans.BeansException;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName InstantiationAwareBeanPostProcessor.java
 * @Description TODO
 * @createTime 2022/11/28
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor {
    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;
}
