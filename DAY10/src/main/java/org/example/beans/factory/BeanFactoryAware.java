package org.example.beans.factory;

import org.example.beans.BeansException;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName BeanFactoryAware.java
 * @Description TODO
 * @createTime 2022/10/27
 */
public interface BeanFactoryAware extends Aware{
    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
