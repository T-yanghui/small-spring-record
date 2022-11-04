package org.example.beans.factory.support;


import org.example.beans.BeansException;
import org.example.beans.factory.ConfigurableListableBeanFactory;
import org.example.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName DefaultListableBeanFactory.java
 * @Description TODO
 * @createTime 2022/10/09
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry, ConfigurableListableBeanFactory {
    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    @Override
    public void preInstantiateSingletons() throws BeansException {
        beanDefinitionMap.keySet().forEach(this::getBean);
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (null == beanDefinition) {
            throw new BeansException("No bean named '" + beanName + "' is defined");
        }
        return beanDefinition;
    }

    @Override
    public boolean containsBeanDefinition(String beanName) {
        return beanDefinitionMap.containsKey(beanName);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return beanDefinitionMap.entrySet().toArray(new String[0]);
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        Map<String, T> resultMap = new HashMap<>();
        beanDefinitionMap.entrySet().stream()
                .filter(e -> type.isAssignableFrom(e.getValue().getBeanClass()))
                    .map(e -> e.getKey()).forEach(e -> resultMap.put(e, (T) getBean(e)));
        return resultMap;
    }
}
