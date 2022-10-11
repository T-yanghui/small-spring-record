package org.example.factory.support;

import org.example.PropertyValue;
import org.example.factory.BeanFactory;
import org.example.factory.PropertyValues;
import org.example.factory.config.BeanDefinition;
import org.example.factory.config.BeanReference;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName DefaultSingletonRegistryTest.java
 * @Description TODO
 * @createTime 2022/10/11
 */
public class DefaultSingletonRegistryTest {
    private DefaultListableBeanFactory beanFactory;
    @Before
    public void setUp(){
        beanFactory=new DefaultListableBeanFactory();
        //注册A
        PropertyValue a1=new PropertyValue("b",new BeanReference("B"));
        PropertyValue a2=new PropertyValue("name"," bad day");
        PropertyValues a=new PropertyValues();
        a.addPropertyValue(a1);
        a.addPropertyValue(a2);
        BeanDefinition beanDefinitionA=new BeanDefinition(A.class,a);
        beanFactory.registerBeanDefinition("A",beanDefinitionA);
        //注册B
        BeanDefinition beanDefinitionB=new BeanDefinition(B.class);
        beanFactory.registerBeanDefinition("B",beanDefinitionB);
    }
    @Test
    public void testDay4(){
        A aInstance=(A)beanFactory.getBean("A");
        aInstance.print();
    }
}
class B{
    public void print(String name){
        System.out.println("B print"+name);
    }
}
class A{
    String name;
    B b;
    public void print(){
        b.print(name);
    }
}