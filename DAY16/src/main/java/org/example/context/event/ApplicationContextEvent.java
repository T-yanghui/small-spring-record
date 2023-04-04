package org.example.context.event;

import org.example.context.ApplicationContext;
import org.example.context.ApplicationEvent;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName ApplicationContextEvent.java
 * @Description TODO
 * @createTime 2022/11/01
 */
public class ApplicationContextEvent extends ApplicationEvent {
    public ApplicationContextEvent(Object source) {
        super(source);
    }

    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext) getSource();
    }
}
