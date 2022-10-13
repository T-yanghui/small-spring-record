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
    private Class beanClass;
    private PropertyValues propertyValues;

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues==null?new PropertyValues():propertyValues;
    }

    public BeanDefinition(Class beanClass){
        this.beanClass=beanClass;
        this.propertyValues=new PropertyValues();
    }

    public Class getBeanClass() {
        return beanClass;
    }
    public void setBeanClass(Class beanClass){
        this.beanClass=beanClass;
    }
    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }

}
