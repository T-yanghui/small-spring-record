package org.example.beans.factory.support.common;

import org.example.beans.BeansException;
import org.example.beans.factory.config.BeanPostProcessor;
import org.example.beans.factory.support.bean.UserService;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName MyBeanPostProcessor.java
 * @Description TODO
 * @createTime 2022/10/19
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessorBeforeInitialization(Object bean, String beanName) throws BeansException {
        if("userService".equals(beanName)){
            UserService userService=(UserService) bean;
            userService.setCompany("PWC");
        }
        return bean;
    }

    @Override
    public Object postProcessorAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }
}
