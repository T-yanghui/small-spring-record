package org.example.context.support;

import org.example.beans.BeansException;
import org.example.beans.factory.BeanFactory;
import org.example.beans.factory.ConfigurableListableBeanFactory;
import org.example.beans.factory.config.BeanFactoryPostProcessor;
import org.example.beans.factory.config.BeanPostProcessor;
import org.example.beans.factory.support.DefaultListableBeanFactory;
import org.example.context.ConfigurableApplicationContext;
import org.example.core.io.DefaultResourceLoader;
import org.example.core.io.ResourceLoader;

import java.util.Map;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName AbstractApplicationContext.java
 * @Description TODO
 * @createTime 2022/10/18
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {
    @Override
    public void refresh() throws BeansException {
        // 1. 创建bean factory,并加载bean definition
        refreshBeanfactory();
        // 2. 获取bean factory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
        // 3. 添加 ApplicationContextAwareProcessor,让继承自 ApplicationContextAware 的 Bean 对象都能感知所属的 ApplicationContext
        beanFactory.addBeanPostProcessor(new ApplicationContextAwarePostProcessor(this));
        // 4. 在bean实例化之前，执行bean factory post processors
        invokeBeanFactoryPostProcessors(beanFactory);
        // 5. 注册beanPostProcessors
        registerBeanPostProcessors(beanFactory);
        // 6. 提前实例化单例bean
        beanFactory.preInstantiateSingletons();
    }

    protected abstract void refreshBeanfactory() throws BeansException;


    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
            beanFactoryPostProcessor.postProcessorBeanFactory(beanFactory);
        }
    }

    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()) {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }

    @Override
    public Object getBean(String beanName) throws BeansException {
        return getBeanFactory().getBean(beanName);
    }

    @Override
    public Object getBean(String beanName, Object... args) throws BeansException {
        return getBeanFactory().getBean(beanName, args);
    }

    @Override
    public <T> T getBean(String beanName, Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(beanName, requiredType);
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeansOfType(type);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    @Override
    public void registerShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(this::close));
    }

    @Override
    public void close() {
        getBeanFactory().destroySingletons();
    }
}
