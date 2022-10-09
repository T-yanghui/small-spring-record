package spring.factory.config;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName SingletonBeanRegistry.java
 * @Description TODO
 * @createTime 2022/10/09
 */
public interface SingletonBeanRegistry {
    Object getSingleton(String beanName);
}
