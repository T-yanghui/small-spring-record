package org.example.context.event;

import org.example.beans.factory.BeanFactory;
import org.example.context.ApplicationEvent;
import org.example.context.ApplicationListener;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName SimpleApplicationEventMulticaster.java
 * @Description TODO
 * @createTime 2022/11/01
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster{
    public SimpleApplicationEventMulticaster(BeanFactory beanFactory){
        setBeanFactory(beanFactory);
    }
    @SuppressWarnings("unchecked")
    @Override
    public void multicastEvent(ApplicationEvent event) {
        for(ApplicationListener applicationListener:getApplicationListeners(event)){
            applicationListener.onApplicationEvent(event);
        }
    }
}
