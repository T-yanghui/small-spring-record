package org.example.beans.factory.support;

import cn.hutool.core.io.IoUtil;
import org.example.beans.PropertyValue;
import org.example.beans.PropertyValues;
import org.example.beans.factory.config.BeanDefinition;
import org.example.beans.factory.config.BeanReference;
import org.example.beans.factory.support.bean.UserDao;
import org.example.beans.factory.support.bean.UserService;
import org.example.beans.factory.support.common.MyBeanFactoryPostProcessor;
import org.example.beans.factory.support.common.MyBeanPostProcessor;
import org.example.beans.factory.xml.XmlBeanDefinitionReader;
import org.example.context.support.ClassPathXmlApplicationContext;
import org.example.core.io.DefaultResourceLoader;
import org.example.core.io.Resource;
import org.example.core.io.ResourceLoader;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName ApiTest.java
 * @Description TODO
 * @createTime 2022/10/13
 */
public class ApiTest {
    @Test
    public void ClassPathXmlApplicationContext_test(){
        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:springPostProcessor.xml");
        applicationContext.registerShutdownHook();
        UserService userService=applicationContext.getBean("userService",UserService.class);
        System.out.println(userService.queryUserInfo());
        System.out.println(userService.getLocation());
        System.out.println(userService.getCompany());
    }
}
