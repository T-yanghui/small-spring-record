package org.example.context.event;

import org.example.context.ApplicationEvent;
import org.example.context.ApplicationListener;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName ApplicationEventMulticaster.java
 * @Description TODO Multicast ApplicationEvent
 * @createTime 2022/11/01
 */
public interface ApplicationEventMulticaster {
    /**
     * Add a listener to be notified of all events.
     * @param listener
     */
    void addApplicationListener(ApplicationListener<?> listener);

    /**
     * remove a listener from notification list.
     * @param listener
     */
    void removeApplicationListener(ApplicationListener<?> listener);

    /**
     * Multicast the given application event to appropriate listeners.
     * @param event
     */
    void multicastEvent(ApplicationEvent event);
}
