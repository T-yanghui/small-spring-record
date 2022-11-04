package org.example.context;

import java.util.EventListener;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName ApplicationListener.java
 * @Description TODO
 * @createTime 2022/11/01
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {
    /**
     * Handle an application event
     * @param event
     */
    void onApplicationEvent(E event);
}
