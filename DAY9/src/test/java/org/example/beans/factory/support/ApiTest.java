package org.example.beans.factory.support;

import org.example.beans.factory.support.bean.UserService;
import org.example.context.support.ClassPathXmlApplicationContext;
import org.junit.Before;
import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

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
    public void test_prototype() {
        // 1.初始化 BeanFactory

        // 2. 获取Bean对象调用方法
        UserService userService01 = classPathXmlApplicationContext.getBean("userService", UserService.class);
        UserService userService02 = classPathXmlApplicationContext.getBean("userService", UserService.class);

        // 3. 配置 scope="prototype/singleton"
        System.out.println(userService01);
        System.out.println(userService02);

        // 4. 打印十六进制哈希
        System.out.println(userService01 + " 十六进制哈希：" + Integer.toHexString(userService01.hashCode()));
        System.out.println(ClassLayout.parseInstance(userService01).toPrintable());
    }
    @Test
    public void test_factory_bean() {
        UserService userService =classPathXmlApplicationContext.getBean("userService", UserService.class);
        System.out.println("测试结果：" + userService.queryName());
    }
}
