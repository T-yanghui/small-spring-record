package org.example.beans.factory;

import org.example.beans.factory.config.AutowireCapableBeanFactory;
import org.example.beans.factory.config.ConfigurableBeanFactory;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName ConfigurableListableBeanFactory.java
 * @Description TODO
 * @createTime 2022/10/13
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, ConfigurableBeanFactory, AutowireCapableBeanFactory{
}
