package org.example.beans.factory.support.event;

import org.example.context.ApplicationListener;
import org.example.context.event.ContextClosedEvent;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName ContextClosedEventListener.java
 * @Description TODO
 * @createTime 2022/11/01
 */
public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("closed: "+event.getClass().getSimpleName());
    }
}
