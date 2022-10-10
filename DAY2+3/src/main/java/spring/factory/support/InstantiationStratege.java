package spring.factory.support;

import spring.BeansException;
import spring.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

public interface InstantiationStratege {
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor,Object[] args) throws BeansException;
}
