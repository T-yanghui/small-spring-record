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
    public void test_BeanFactoryPostProcessorAndBeanPostProcessor(){
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 读取配置文件&注册Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        // 3. BeanDefinition 加载完成 & Bean实例化之前，修改 BeanDefinition 的属性值
        MyBeanFactoryPostProcessor beanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
        beanFactoryPostProcessor.postProcessorBeanFactory(beanFactory);

        // 4. Bean实例化之后，修改 Bean 属性信息
        MyBeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
        beanFactory.addBeanPostProcessor(beanPostProcessor);

        // 5. 获取Bean对象调用方法
        UserService userService = beanFactory.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }
    @Test
    public void ClassPathXmlApplicationContext_test(){
        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:springPostProcessor.xml");
        UserService userService=applicationContext.getBean("userService",UserService.class);
        System.out.println(userService.queryUserInfo());
        System.out.println(userService.getLocation());
        System.out.println(userService.getCompany());
    }
}
