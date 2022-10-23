package org.example.beans;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName spring.BeansException.java
 * @Description TODO
 * @createTime 2022/10/09
 */
public class BeansException extends RuntimeException {
    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg);
    }
}
