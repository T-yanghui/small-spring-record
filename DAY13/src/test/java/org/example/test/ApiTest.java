package org.example.test;

import org.example.beans.BeansException;
import org.example.beans.factory.config.BeanPostProcessor;
import org.example.context.support.ClassPathXmlApplicationContext;
import org.example.test.bean.IUserService;
import org.junit.Test;

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
    public void test_scan() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-scan.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }

    @Test
    public void test_property() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-property.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果：" + userService);
    }

    @Test
    public void test_beanPost() {

        BeanPostProcessor beanPostProcessor = new BeanPostProcessor() {
            @Override
            public Object postProcessorBeforeInitialization(Object bean, String beanName) throws BeansException {
                return null;
            }

            @Override
            public Object postProcessorAfterInitialization(Object bean, String beanName) throws BeansException {
                return null;
            }
        };

        List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();
        beanPostProcessors.add(beanPostProcessor);
        beanPostProcessors.add(beanPostProcessor);
        beanPostProcessors.remove(beanPostProcessor);

        System.out.println(beanPostProcessors.size());
    }
}
