package org.example.beans.factory.config;

import org.example.beans.BeansException;
import org.example.beans.factory.BeanFactory;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName AutowireCapableBeanFactory.java
 * @Description TODO
 * @createTime 2022/10/13
 */
public interface AutowireCapableBeanFactory extends BeanFactory {
    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException;

    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException;
}
