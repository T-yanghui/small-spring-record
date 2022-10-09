package org.example;


import org.junit.Before;
import org.junit.Test;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName BeanFactoryTest.java
 * @Description TODO
 * @createTime 2022/10/08
 */
public class BeanFactoryTest {
    BeanDefinition serviceBeanDefinition;
    BeanFactory beanFactory;
    @Before
    public void setup(){
        serviceBeanDefinition=new BeanDefinition(new Service());
        beanFactory=new BeanFactory();
        beanFactory.registerBeanDefinition("service",serviceBeanDefinition);
    }
    @Test
    public void ApiTest(){
        Service service=(Service)beanFactory.getBean("service");
        service.doWork();
    }
}
class Service{
    public void doWork(){
        System.out.println("service working...");
    }
}