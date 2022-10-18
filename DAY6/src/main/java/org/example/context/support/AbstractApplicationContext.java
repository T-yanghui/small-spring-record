package org.example.context.support;

import org.example.beans.BeansException;
import org.example.beans.factory.ConfigurableListableBeanFactory;
import org.example.beans.factory.support.DefaultListableBeanFactory;
import org.example.context.ConfigurableApplicationContext;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName AbstractApplicationContext.java
 * @Description TODO
 * @createTime 2022/10/18
 */
public abstract class AbstractApplicationContext extends DefaultListableBeanFactory implements ConfigurableApplicationContext {
    @Override
    public void refresh() throws BeansException {

    }
    protected abstract void refreshBeanfactory() throws BeansException;
    protected abstract ConfigurableListableBeanFactory getBeanFactory();

}
