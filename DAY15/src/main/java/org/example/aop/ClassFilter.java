package org.example.aop;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName ClassFilter.java
 * @Description Filter that restricts matching of a pointcut or introduction to
 *  * a given set of target classes.
 * @createTime 2022/11/07
 */
public interface ClassFilter {
    /**
     ** @title matches
     ** @description Should the pointcut apply to the given interface or target class?
     **/
    boolean matches(Class<?> clazz);
}
