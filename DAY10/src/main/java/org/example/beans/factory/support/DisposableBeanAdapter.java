package org.example.beans.factory.support;

import cn.hutool.core.util.StrUtil;
import org.example.beans.BeansException;
import org.example.beans.factory.DisposableBean;
import org.example.beans.factory.config.BeanDefinition;

import java.lang.reflect.Method;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName DisposableBeanAdapter.java
 * @Description TODO
 * @createTime 2022/10/23
 */
public class DisposableBeanAdapter implements DisposableBean {
    private final Object bean;
    private final String beanName;
    private String destroyMethodName;

    public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition) {
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = beanDefinition.getDestroyMethodName();
    }

    @Override
    public void destroy() throws Exception {
        //1. 判断当前bean是否实现接口disposableBean
        if (bean instanceof DisposableBean) {
            ((DisposableBean) bean).destroy();
        }
        //2. 判断配置文件是否有destroy-method
        if (StrUtil.isNotEmpty(destroyMethodName) && !(bean instanceof DisposableBean && "destroy".equals(destroyMethodName))) {
            try{
                Method destroyMethod=bean.getClass().getMethod(destroyMethodName);
                destroyMethod.invoke(bean);
            }catch (Exception ex){
                throw new BeansException("Couldn't find a destroy method named '" + destroyMethodName + "' on bean with name '" + beanName + "'");
            }
        }
    }
}
