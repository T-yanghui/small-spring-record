package org.example.context;

import org.example.beans.BeansException;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName ApplicationContextAware.java
 * @Description TODO
 * @createTime 2022/10/27
 */
public interface ApplicationContextAware {
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
