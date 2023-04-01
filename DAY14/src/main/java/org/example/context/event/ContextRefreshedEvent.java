package org.example.context.event;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName ContextRefreshedEvent.java
 * @Description TODO
 * @createTime 2022/11/01
 */
public class ContextRefreshedEvent extends ApplicationContextEvent{
    public ContextRefreshedEvent(Object source) {
        super(source);
    }
}
