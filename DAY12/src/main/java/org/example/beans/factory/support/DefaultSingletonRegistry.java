package org.example.beans.factory.support;


import org.example.beans.BeansException;
import org.example.beans.factory.DisposableBean;
import org.example.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName DefaultSingletonRegistry.java
 * @Description TODO
 * @createTime 2022/10/09
 */
public class DefaultSingletonRegistry implements SingletonBeanRegistry {
    private final HashMap<String, Object> singletonObjects = new HashMap<String, Object>();
    private final HashMap<String, DisposableBean> disposableBeans = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    @Override
    public void registerSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }

    public void registerDisposableBean(String beanName, DisposableBean bean) {
        disposableBeans.put(beanName, bean);
    }

    public void destroySingletons() {
        String[] disposableBeanNames = disposableBeans.keySet().toArray(new String[0]);
        for (String disposableBeanName : disposableBeanNames) {
            DisposableBean disposableBean = disposableBeans.get(disposableBeanName);
            try {
                disposableBean.destroy();
            } catch (Exception ex) {
                throw new BeansException("Destroy method on bean with name '" + disposableBeanName + "' threw an exception", ex);
            }
        }
    }
}
