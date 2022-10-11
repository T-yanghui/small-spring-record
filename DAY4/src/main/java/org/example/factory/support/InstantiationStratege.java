package org.example.factory.support;


import org.example.BeansException;
import org.example.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

public interface InstantiationStratege {
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;
}
