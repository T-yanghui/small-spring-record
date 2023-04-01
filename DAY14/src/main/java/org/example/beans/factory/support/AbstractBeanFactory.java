package org.example.beans.factory.support;


import org.example.beans.BeansException;
import org.example.beans.factory.BeanFactory;
import org.example.beans.factory.FactoryBean;
import org.example.beans.factory.config.BeanDefinition;
import org.example.beans.factory.config.BeanPostProcessor;
import org.example.beans.factory.config.ConfigurableBeanFactory;
import org.example.util.ClassUtils;
import org.example.util.StringValueResolver;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName AbstractBeanFactory.java
 * @Description TODO
 * @createTime 2022/10/09
 */
public abstract class AbstractBeanFactory extends FactoryBeanRegistrySupport implements ConfigurableBeanFactory {
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();
    private ClassLoader beanClassLoader = ClassUtils.getDefaultClassLoader();
    private final List<StringValueResolver> embeddedValueResolvers = new ArrayList<>();

    @Override
    public Object getBean(String beanName, Object... args) throws BeansException {
        return doGetBean(beanName, args);
    }

    @Override
    public <T> T getBean(String beanName, Class<T> requiredType) throws BeansException {
        return (T) getBean(beanName);
    }

    @Override
    public Object getBean(String beanName) throws BeansException {
        return doGetBean(beanName, null);
    }

    protected <T> T doGetBean(String beanName, Object... args) {
        Object bean = getSingleton(beanName);

        if (null == bean) {
            BeanDefinition beanDefinition = getBeanDefinition(beanName);
            bean = createBean(beanName, beanDefinition, args);
        }

        return (T) getObjectForBeanInstance(bean, beanName);
    }

    private Object getObjectForBeanInstance(Object beanInstance, String beanName) {
        if (!(beanInstance instanceof FactoryBean)) {
            return beanInstance;
        }
        Object object = getCachedObjectForFactoryBean(beanName);
        if (null == object) {
            FactoryBean<?> factoryBean = (FactoryBean<?>) beanInstance;
            object = getObjectFromFactoryBean(factoryBean, beanName);
        }
        return object;
    }

    protected abstract BeanDefinition getBeanDefinition(String name) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        Objects.requireNonNull(beanPostProcessor, "BeanPostProcessor must not be null");
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

    @Override
    public void addEmbeddedResolver(StringValueResolver valueResolver) {
        this.embeddedValueResolvers.add(valueResolver);
    }

    @Override
    public String resolveEmbeddedValue(String value) {
        String result = value;
        for (StringValueResolver resolver : embeddedValueResolvers) {
            result = resolver.resolveStringValue(value);
        }
        return result;
    }

    public List<BeanPostProcessor> getBeanPostProcessors() {
        return this.beanPostProcessors;
    }

    public ClassLoader getBeanClassLoader() {
        return this.beanClassLoader;
    }
}
