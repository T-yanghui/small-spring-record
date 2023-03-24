package org.example.aop.framework.autoproxy;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.example.aop.*;
import org.example.aop.aspectj.AspectJExpressionPointcutAdvisor;
import org.example.aop.framework.ProxyFactory;
import org.example.beans.BeansException;
import org.example.beans.factory.BeanFactory;
import org.example.beans.factory.BeanFactoryAware;
import org.example.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.example.beans.factory.support.DefaultListableBeanFactory;
import java.util.Collection;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName DefaultAdvisorAutoProxyCreator.java
 * @Description TODO
 * @createTime 2022/11/28
 */
public class DefaultAdvisorAutoProxyCreator implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {
    private DefaultListableBeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (DefaultListableBeanFactory) beanFactory;
    }

    @Override
    public Object postProcessorBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessorAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if (isInfrastructureClass(beanClass)) {
            return null;
        }
        Collection<AspectJExpressionPointcutAdvisor> advisors = beanFactory.getBeansOfType(AspectJExpressionPointcutAdvisor.class).values();
        for (AspectJExpressionPointcutAdvisor advisor : advisors) {
            ClassFilter classFilter = advisor.getPointcut().getClassFilter();
            if (classFilter.matches(beanClass)) {
                AdvisedSupport advisedSupport = new AdvisedSupport();

                TargetSource targetSource = null;
                try {
                    targetSource = new TargetSource(beanClass.getDeclaredConstructor().newInstance());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                advisedSupport.setTargetSource(targetSource);
                advisedSupport.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
                advisedSupport.setMethodMatcher(advisor.getPointcut().getMethodMatcher());
                advisedSupport.setProxyTargetClass(false);

                return new ProxyFactory(advisedSupport).getProxy();
            }
        }
        return null;
    }

    private boolean isInfrastructureClass(Class<?> beanClass) {
        return Advice.class.isAssignableFrom(beanClass) || Pointcut.class.isAssignableFrom(beanClass) || Advisor.class.isAssignableFrom(beanClass);
    }
}
