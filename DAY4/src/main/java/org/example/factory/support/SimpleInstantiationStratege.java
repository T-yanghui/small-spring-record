package org.example.factory.support;



import org.example.BeansException;
import org.example.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SimpleInstantiationStratege implements InstantiationStratege {
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        Class clazz = beanDefinition.getBeanClass();
        try {
            if (null == ctor) {
                return clazz.getDeclaredConstructor().newInstance();
            }else{
                return ctor.newInstance(args);
            }
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException |
                 InstantiationException e) {
            throw new BeansException("Failed to instantiate [" + clazz.getSimpleName() + " ]", e);
        }
    }
}
