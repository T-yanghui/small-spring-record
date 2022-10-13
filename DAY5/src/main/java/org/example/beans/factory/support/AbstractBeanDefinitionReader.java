package org.example.beans.factory.support;

import org.example.beans.BeansException;
import org.example.core.io.DefaultResourceLoader;
import org.example.core.io.Resource;
import org.example.core.io.ResourceLoader;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName AbstractBeanDefinitionReader.java
 * @Description TODO
 * @createTime 2022/10/13
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader{
    private final BeanDefinitionRegistry registry;
    private ResourceLoader resourceLoader;

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this.registry = registry;
        this.resourceLoader=new DefaultResourceLoader();
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
