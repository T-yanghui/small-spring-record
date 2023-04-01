package org.example.beans.factory;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName BeanNameAware.java
 * @Description TODO
 * @createTime 2022/10/27
 */
public interface BeanNameAware extends Aware{
    void setBeanName(String beanName);
}
