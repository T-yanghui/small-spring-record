package spring.factory;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName BeanFactory.java
 * @Description TODO
 * @createTime 2022/10/09
 */
public interface BeanFactory {
    Object getBean(String BeanName);
    Object getBean(String BeanName,Object... args);
}
