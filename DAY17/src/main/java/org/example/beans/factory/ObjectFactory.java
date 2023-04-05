package org.example.beans.factory;

import org.example.beans.BeansException;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName ObjectFactory.java
 * @Description TODO
 * @createTime 2023/04/04
 */
public interface ObjectFactory<T> {
    T getObject() throws BeansException;
}
