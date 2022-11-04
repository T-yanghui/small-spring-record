package org.example.beans.factory.support.event;

import org.example.context.ApplicationListener;
import org.example.context.event.ContextRefreshedEvent;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName ContextRefreshedEventListener.java
 * @Description TODO
 * @createTime 2022/11/01
 */
public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("Event: refreshed "+ event.getClass().getSimpleName());
    }
}
