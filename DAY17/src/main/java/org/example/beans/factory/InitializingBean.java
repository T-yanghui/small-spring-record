package org.example.beans.factory;

import org.example.beans.BeansException;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName InitializingBean.java
 * @Description TODO 在BeanFactory执行属性填充后调用
 * @createTime 2022/10/23
 */
public interface InitializingBean {
    /**
     * @title afterPropertiesSet
     * @description 属性填充后调用
     */
    void afterPropertiesSet() throws Exception;
}
