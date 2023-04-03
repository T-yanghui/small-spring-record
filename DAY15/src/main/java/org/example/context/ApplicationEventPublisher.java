package org.example.context;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName ApplicationEventPublisher.java
 * @Description TODO
 * @createTime 2022/11/01
 */
public interface ApplicationEventPublisher {
    /**
     *  Notify all listeners registered with this application of an application
     *  event. Events may be framework events (such as RequestHandledEvent)
     *  or application-specific events.
     * @param event
     */
    void publishEvent(ApplicationEvent event);
}
