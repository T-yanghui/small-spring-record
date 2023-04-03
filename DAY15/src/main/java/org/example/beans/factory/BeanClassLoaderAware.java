package org.example.beans.factory;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName BeanClassloaderAware.java
 * @Description TODO
 * @createTime 2022/10/27
 */
public interface BeanClassLoaderAware extends Aware{
    void setBeanClassLoader(ClassLoader classLoader);
}
