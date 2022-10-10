package spring.factory.support;

import spring.BeansException;
import spring.factory.config.BeanDefinition;

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
