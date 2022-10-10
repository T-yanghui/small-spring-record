package spring.factory.support;

import spring.factory.config.BeanDefinition;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName BeanDefinitionRegistry.java
 * @Description TODO
 * @createTime 2022/10/09
 */
public interface BeanDefinitionRegistry {
    void registerBeanDefinition(String beanName,BeanDefinition beanDefinition);
}
