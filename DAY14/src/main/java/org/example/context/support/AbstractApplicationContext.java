package org.example.context.support;

import org.example.beans.BeansException;
import org.example.beans.factory.BeanFactory;
import org.example.beans.factory.ConfigurableListableBeanFactory;
import org.example.beans.factory.config.BeanFactoryPostProcessor;
import org.example.beans.factory.config.BeanPostProcessor;
import org.example.beans.factory.support.DefaultListableBeanFactory;
import org.example.context.ApplicationEvent;
import org.example.context.ApplicationListener;
import org.example.context.ConfigurableApplicationContext;
import org.example.context.event.*;
import org.example.core.io.DefaultResourceLoader;
import org.example.core.io.ResourceLoader;

import java.util.Collection;
import java.util.Collections;
import java.util.EventListener;
import java.util.Map;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName AbstractApplicationContext.java
 * @Description TODO
 * @createTime 2022/10/18
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {
    public static final String APPLICATION_EVENT_MULTICASTER_BEAN_NAME = "applicationEventMulticaster";

    private ApplicationEventMulticaster applicationEventMulticaster;


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
        // 6. init applicationEventMulticaster
        initApplicationEventMulticaster();
        // 7. register Listeners
        registerListeners();
        // 8. 提前实例化单例bean
        beanFactory.preInstantiateSingletons();
        // 9. publish event about refreshed context
        finishRefresh();
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
    private void initApplicationEventMulticaster(){
        ConfigurableListableBeanFactory beanFactory=getBeanFactory();
        applicationEventMulticaster=new SimpleApplicationEventMulticaster(beanFactory);
        beanFactory.registerSingleton(APPLICATION_EVENT_MULTICASTER_BEAN_NAME, applicationEventMulticaster);
    }
    private void registerListeners(){
        Collection<ApplicationListener> applicationListeners=getBeansOfType(ApplicationListener.class).values();
        for(ApplicationListener listener:applicationListeners){
            applicationEventMulticaster.addApplicationListener(listener);
        }
    }
    private void  finishRefresh(){
        publishEvent(new ContextRefreshedEvent(this));
    }

    @Override
    public void publishEvent(ApplicationEvent event) {
        applicationEventMulticaster.multicastEvent(event);
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
    public <T> T getBean(Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(requiredType);
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
        publishEvent(new ContextClosedEvent(this));
        getBeanFactory().destroySingletons();
    }
}
