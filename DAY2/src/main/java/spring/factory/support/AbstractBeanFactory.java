package spring.factory.support;


import spring.factory.BeanFactory;
import spring.factory.config.BeanDefinition;
import spring.BeansException;

import java.beans.Beans;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName AbstractBeanFactory.java
 * @Description TODO
 * @createTime 2022/10/09
 */
public abstract class AbstractBeanFactory extends DefaultSingletonRegistry implements BeanFactory {
    @Override
    public Object getBean(String beanName) throws BeansException {
        Object bean = getSingleton(beanName);
        if (null == bean) {
            BeanDefinition beanDefinition = getBeanDefinition(beanName);
            bean=createBean(beanName,beanDefinition);
        }
        return bean;
    }

    protected abstract BeanDefinition getBeanDefinition(String name) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;
}
