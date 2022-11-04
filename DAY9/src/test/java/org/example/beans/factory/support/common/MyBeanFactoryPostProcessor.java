package org.example.beans.factory.support.common;

import org.example.beans.BeansException;
import org.example.beans.PropertyValue;
import org.example.beans.PropertyValues;
import org.example.beans.factory.ConfigurableListableBeanFactory;
import org.example.beans.factory.config.BeanDefinition;
import org.example.beans.factory.config.BeanFactoryPostProcessor;
import org.example.beans.factory.config.ConfigurableBeanFactory;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName MyBeanFactoryPostProcessor.java
 * @Description TODO
 * @createTime 2022/10/19
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessorBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("location", "广州"));
    }
}
