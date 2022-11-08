package org.example.beans.factory.support;

import org.example.beans.factory.support.event.CustomEvent;
import org.example.context.support.ClassPathXmlApplicationContext;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName ApiTest.java
 * @Description TODO
 * @createTime 2022/10/13
 */
public class ApiTest {
    private ClassPathXmlApplicationContext classPathXmlApplicationContext;

    @Before
    public void setUp() {
        classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        classPathXmlApplicationContext.registerShutdownHook();
    }

    @Test
    public void test_event(){
        classPathXmlApplicationContext.publishEvent(new CustomEvent(classPathXmlApplicationContext,10001L,"bad day..."));
    }
    @Test
    public void test_merge(){
        System.out.println(merge());
    }
    public int merge(){
        int a=0;
        try{
            a=1;
            return a;
        }finally {
            a=2;
            //return a;
        }
    }
}
