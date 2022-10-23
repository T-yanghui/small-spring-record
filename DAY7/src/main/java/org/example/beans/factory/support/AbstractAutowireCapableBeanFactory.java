package org.example.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import org.example.beans.BeansException;
import org.example.beans.PropertyValue;
import org.example.beans.factory.DisposableBean;
import org.example.beans.factory.InitializingBean;
import org.example.beans.factory.config.AutowireCapableBeanFactory;
import org.example.beans.factory.config.BeanDefinition;
import org.example.beans.factory.config.BeanPostProcessor;
import org.example.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName AbstractAutowireCapableBeanFactory.java
 * @Description TODO
 * @createTime 2022/10/09
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory implements AutowireCapableBeanFactory {
    private InstantiationStratege instantiationStratege = new CglibSubclassingInstantiationStratege();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean;
        try {
            //1. 创建实例
            bean = createBeanInstance(beanName, beanDefinition, args);
            //2. 充填属性
            applyPropertyValues(beanName, bean, beanDefinition);
            //3. 执行初始化方法和bean的前置以及后置增强器
            bean = initializeBean(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean " + beanName + " failed", e);
        }
        registerDisposableBeanIfNecessary(beanName, bean, beanDefinition);
        addSingleton(beanName, bean);
        return bean;
    }

    protected void registerDisposableBeanIfNecessary(String beanName, Object bean, BeanDefinition beanDefinition) {
        if (bean instanceof DisposableBean || StrUtil.isNotEmpty(beanDefinition.getDestroyMethodName())) {
            registerDisposableBean(beanName, new DisposableBeanAdapter(bean, beanName, beanDefinition));
        }
    }

    protected Object createBeanInstance(String beanName, BeanDefinition beanDefinition, Object[] args) {
        Constructor constructorToUse = null;
        Class beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] constructors = beanClass.getDeclaredConstructors();
        for (Constructor ctor : constructors) {
            if (null != args && ctor.getParameterCount() == args.length) {
                constructorToUse = ctor;
                break;
            }
        }
        return getInstantiationStratege().instantiate(beanDefinition, beanName, constructorToUse, args);
    }

    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            PropertyValue[] propertyValues = beanDefinition.getPropertyValues().getPropertyValues();
            for (PropertyValue propertyValue : propertyValues) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();
                if (value instanceof BeanReference) {
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (Exception e) {
            throw new BeansException("Erro setting property values " + beanName, e);
        }
    }

    public InstantiationStratege getInstantiationStratege() {
        return instantiationStratege;
    }

    public void setInstantiationStratege(InstantiationStratege instantiationStratege) {
        this.instantiationStratege = instantiationStratege;
    }

    private Object initializeBean(String beanName, Object bean, BeanDefinition beanDefinition) {
        //1. 前置处理
        Object wrappedBean = applyBeanPostProcessorsBeforeInitialization(bean, beanName);
        //2. 初始化方法
        try {
            invokeInitMethods(beanName, wrappedBean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Invocation of init method of bean[" + beanName + "] failed", e);
        }
        //3. 后置处理
        wrappedBean = applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
        return wrappedBean;
    }

    private void invokeInitMethods(String beanName, Object bean, BeanDefinition beanDefinition) throws BeansException {
        //1. 判断是否继承InitializingBean 接口
        if (bean instanceof InitializingBean) {
            ((InitializingBean) bean).afterPropertiesSet();
        }
        //2. 判断xml文件是否配置init-method
        String initMethodName = beanDefinition.getInitMethodName();
        if (StrUtil.isNotEmpty(initMethodName) && !(bean instanceof InitializingBean)) {
            try {
                Method initMethod = beanDefinition.getBeanClass().getMethod(initMethodName);
                initMethod.invoke(bean);
            } catch (Exception ex) {
                throw new BeansException("Could not find an init method named '" + initMethodName + "' on bean with name '" + beanName + "'");
            }
        }
    }

    @Override
    public Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException {
        Object result = existingBean;
        for (BeanPostProcessor beanPostProcessor : getBeanPostProcessors()) {
            Object current = beanPostProcessor.postProcessorBeforeInitialization(result, beanName);
            if (null == current) return result;
            result = current;
        }
        return result;
    }

    @Override
    public Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException {
        Object result = existingBean;
        for (BeanPostProcessor beanPostProcessor : getBeanPostProcessors()) {
            Object current = beanPostProcessor.postProcessorAfterInitialization(result, beanName);
            if (null == current) return result;
            result = current;
        }
        return result;
    }
}
