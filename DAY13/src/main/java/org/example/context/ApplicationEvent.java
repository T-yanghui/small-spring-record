package org.example.context;

import java.util.EventObject;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName ApplicationEvent.java
 * @Description TODO Class to be extended by all application events. Abstract as it doesn't make sense for generic events to be published directly.
 * @createTime 2022/11/01
 */
public abstract class ApplicationEvent extends EventObject {

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public ApplicationEvent(Object source) {
        super(source);
    }
}
