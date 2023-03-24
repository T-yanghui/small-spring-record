package org.example.beans.factory.config;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName BeanReference.java
 * @Description TODO
 * @createTime 2022/10/11
 */
public class BeanReference {
    private String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }
}
