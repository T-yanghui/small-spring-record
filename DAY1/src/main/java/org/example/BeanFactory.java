package org.example;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName BeanFactory.java
 * @Description TODO
 * @createTime 2022/10/08
 */
public class BeanFactory {
    private Map<String,BeanDefinition> beanDefinitionMap=new ConcurrentHashMap<>();
    public void registerBeanDefinition(String beanName,BeanDefinition beanDefinition){
        beanDefinitionMap.put(beanName,beanDefinition);
    }
    public Object getBean(String beanName){
        return beanDefinitionMap.get(beanName).getBean();
    }
}
