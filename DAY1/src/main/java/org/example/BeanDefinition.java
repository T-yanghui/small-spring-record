package org.example;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName BeanDefinition.java
 * @Description TODO
 * @createTime 2022/10/08
 */
public class BeanDefinition {
    private Object bean;
    public BeanDefinition(Object bean){
        this.bean=bean;
    }
    public Object getBean(){
        return bean;
    }
}
