package org.example.context;

import org.example.beans.BeansException;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName ConfigurableApplicationContext.java
 * @Description TODO
 * @createTime 2022/10/18
 */
public interface ConfigurableApplicationContext extends ApplicationContext {
    void refresh() throws BeansException;
}
