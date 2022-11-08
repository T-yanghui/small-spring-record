package org.example.beans.factory;

import org.example.beans.BeansException;
import org.example.beans.factory.BeanFactory;

import java.util.Map;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName ListableBeanFactory.java
 * @Description TODO
 * @createTime 2022/10/13
 */
public interface ListableBeanFactory extends BeanFactory {
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    String[] getBeanDefinitionNames();
}
