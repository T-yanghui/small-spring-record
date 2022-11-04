package org.example.beans.factory.support;

import org.example.beans.BeansException;
import org.example.core.io.Resource;
import org.example.core.io.ResourceLoader;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName BeanDefinitionReader.java
 * @Description TODO
 * @createTime 2022/10/13
 */
public interface BeanDefinitionReader {
    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;
    void loadBeanDefinitions(String... locations) throws BeansException;

}
