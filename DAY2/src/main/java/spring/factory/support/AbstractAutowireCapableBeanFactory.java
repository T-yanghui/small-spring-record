package spring.factory.support;

import spring.BeansException;
import spring.factory.config.BeanDefinition;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName AbstractAutowireCapableBeanFactory.java
 * @Description TODO
 * @createTime 2022/10/09
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean;
        try{
            bean=getBeanDefinition(beanName).getBeanClass().newInstance();
        }catch (InstantiationException|IllegalAccessException e){
            throw new BeansException("Instantiation of bean "+beanName+" failed",e);
        }
        addSingleton(beanName,bean);
        return bean;
    }
}
