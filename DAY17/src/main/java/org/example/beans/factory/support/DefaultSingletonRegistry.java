package org.example.beans.factory.support;


import org.example.beans.BeansException;
import org.example.beans.factory.DisposableBean;
import org.example.beans.factory.ObjectFactory;
import org.example.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName DefaultSingletonRegistry.java
 * @Description TODO
 * @createTime 2022/10/09
 */
public class DefaultSingletonRegistry implements SingletonBeanRegistry {
    // null value marker
    protected static final Object NULL_OBJECT = new Object();
    //一级缓存，普通对象
    private final HashMap<String, Object> singletonObjects = new HashMap<String, Object>();
    //二级缓存
    protected final Map<String, Object> earlySingletonObjects = new HashMap<>();
    //三级缓存 bean Name --> ObjectFactory
    private final Map<String, ObjectFactory<?>> singletonFactories = new HashMap<>();
    private final HashMap<String, DisposableBean> disposableBeans = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        Object singletonObject = singletonObjects.get(beanName);
        if (null == singletonObject) {
            singletonObject = earlySingletonObjects.get(beanName);
            //二级缓存没有，查询三级缓存
            if (null == singletonObject) {
                ObjectFactory<?> singletonFactory = singletonFactories.get(beanName);
                if (null != singletonFactory) {
                    singletonObject = singletonFactory.getObject();
                    //放入二级缓存，移除三级缓存
                    earlySingletonObjects.put(beanName, singletonObject);
                    singletonFactories.remove(beanName);
                }
            }
        }
        return singletonObject;
    }

    @Override
    public void registerSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
        earlySingletonObjects.remove(beanName);
        singletonFactories.remove(beanName);
    }

    protected void addSingletonFactory(String beanName, ObjectFactory<?> singletonFactory) {
        if (!this.singletonObjects.containsKey(beanName)) {
            this.singletonFactories.put(beanName, singletonFactory);
            this.earlySingletonObjects.remove(beanName);
        }
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
