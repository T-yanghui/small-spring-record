package org.example.test;

import org.example.beans.BeansException;
import org.example.beans.factory.config.BeanPostProcessor;
import org.example.context.support.ClassPathXmlApplicationContext;
import org.example.test.bean.IUserService;
import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName ApiTest.java
 * @Description TODO
 * @createTime 2023/03/25
 */
public class ApiTest {
    @Test
    public void test(){
        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:spring.xml");
        IUserService userService=applicationContext.getBean("userService", IUserService.class);
        System.out.println(userService.queryUserInfo());
    }
}
