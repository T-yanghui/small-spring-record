package org.example.context.event;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName ContextClosedEvent.java
 * @Description TODO
 * @createTime 2022/11/01
 */
public class ContextClosedEvent extends ApplicationContextEvent{
    public ContextClosedEvent(Object source) {
        super(source);
    }
}
