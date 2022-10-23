package org.example.beans.factory;

import org.example.beans.BeansException;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName BeanFactory.java
 * @Description TODO
 * @createTime 2022/10/09
 */
public interface BeanFactory {
    Object getBean(String BeanName) throws BeansException;

    Object getBean(String BeanName, Object... args) throws BeansException;

    <T> T getBean(String BeanName, Class<T> requiredType) throws BeansException;
}
