package org.example.beans.factory.support.event;

import org.example.context.ApplicationListener;

import java.util.Date;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName CustomListener.java
 * @Description TODO
 * @createTime 2022/11/01
 */
public class CustomListener implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("Get event: "+event.getSource() +" time "+new Date());
        System.out.println("msg: "+event.getMessage());
    }
}
