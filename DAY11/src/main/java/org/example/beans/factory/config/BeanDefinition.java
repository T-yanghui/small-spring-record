package org.example.beans.factory.config;


import org.example.beans.PropertyValues;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName BeanDefinition.java
 * @Description TODO
 * @createTime 2022/10/09
 */
public class BeanDefinition {
    String SCOPE_SINGLETON = ConfigurableBeanFactory.SCOPE_SINGLETON;
    String SCOPE_PROTOTYPE = ConfigurableBeanFactory.SCOPE_PROTOTYPE;
    private Class beanClass;
    private PropertyValues propertyValues;
    private String initMethodName;
    private String destroyMethodName;
    private String scope = SCOPE_SINGLETON;
    private boolean singleton = true;
    private boolean prototype = false;

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues == null ? new PropertyValues() : propertyValues;
    }

    public BeanDefinition(Class beanClass) {
        this(beanClass,null);
    }

    public void setScope(String scope) {
        this.scope = scope;
        this.singleton=SCOPE_SINGLETON.equals(scope);
        this.prototype=SCOPE_PROTOTYPE.equals(scope);
    }
    public boolean isSingleton(){
        return this.singleton;
    }
    public boolean isPrototype(){
        return this.prototype;
    }
    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }

    public String getInitMethodName() {
        return initMethodName;
    }

    public void setInitMethodName(String initMethodName) {
        this.initMethodName = initMethodName;
    }

    public String getDestroyMethodName() {
        return destroyMethodName;
    }

    public void setDestroyMethodName(String destroyMethodName) {
        this.destroyMethodName = destroyMethodName;
    }
}
