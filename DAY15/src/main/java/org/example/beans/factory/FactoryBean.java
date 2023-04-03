package org.example.beans.factory;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName FactoryBean.java
 * @Description TODO
 * @createTime 2022/10/31
 */
public interface FactoryBean<T> {
    T getObject() throws Exception;

    Class<?> getObjectType();

    boolean isSingleton();
}
