package org.example.context.support;

import org.example.beans.BeansException;
import org.example.beans.factory.config.BeanPostProcessor;
import org.example.context.ApplicationContext;
import org.example.context.ApplicationContextAware;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName ApplicationContextAwarePostProcessor.java
 * @Description TODO
 * @createTime 2022/10/27
 */
public class ApplicationContextAwarePostProcessor implements BeanPostProcessor {
    private final ApplicationContext applicationContext;

    public ApplicationContextAwarePostProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessorBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware) {
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessorAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
