package org.example.beans.factory.support;

import org.example.aop.AdvisedSupport;
import org.example.aop.TargetSource;
import org.example.aop.aspectj.AspectJExpressionPointcut;
import org.example.aop.framework.Cglib2AopProxy;
import org.example.aop.framework.JdkDynamicAopProxy;
import org.example.beans.factory.support.beans.IUserService;
import org.example.beans.factory.support.beans.UserService;
import org.example.beans.factory.support.beans.UserServiceIntercepter;
import org.example.context.support.ClassPathXmlApplicationContext;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;

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
    public void test_aop() throws NoSuchMethodException {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut("execution(* org.example.beans.factory.support.beans.UserService.*(..))");
        Class<UserService> clazz = UserService.class;
        Method method = clazz.getDeclaredMethod("register", String.class);

        System.out.println(pointcut.matches(clazz));
        System.out.println(pointcut.matches(method, clazz));
    }

    @Test
    public void test_dynamic() {
        IUserService userService=new UserService();
        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.setMethodMatcher(new AspectJExpressionPointcut("execution(* org.example.beans.factory.support.beans.IUserService.*(..))"));
        advisedSupport.setTargetSource(new TargetSource(userService));
        advisedSupport.setMethodInterceptor(new UserServiceIntercepter());

        IUserService proxy_jdk= (IUserService) new JdkDynamicAopProxy(advisedSupport).getProxy();
        IUserService proxy_cglib= (IUserService) new Cglib2AopProxy(advisedSupport).getProxy();

        System.out.println(proxy_jdk.queryUserInfo());
        System.out.println(proxy_jdk.register("Tessa"));
    }
}
