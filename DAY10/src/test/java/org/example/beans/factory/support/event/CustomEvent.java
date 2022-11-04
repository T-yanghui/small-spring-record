package org.example.beans.factory.support.event;

import org.example.context.event.ApplicationContextEvent;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName CustomEvent.java
 * @Description TODO
 * @createTime 2022/11/01
 */
public class CustomEvent extends ApplicationContextEvent {
    private Long id;
    private String message;
    public CustomEvent(Object source,Long id,String message){
        super(source);
        this.id=id;
        this.message=message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
