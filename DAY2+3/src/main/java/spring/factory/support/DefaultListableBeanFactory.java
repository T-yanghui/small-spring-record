package spring.factory.support;

import spring.BeansException;
import spring.factory.config.BeanDefinition;

import java.util.HashMap;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName DefaultListableBeanFactory.java
 * @Description TODO
 * @createTime 2022/10/09
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {
    private final HashMap<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    @Override
    protected BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        return beanDefinitionMap.get(beanName);
    }
}
