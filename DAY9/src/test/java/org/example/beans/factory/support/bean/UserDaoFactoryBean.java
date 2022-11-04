package org.example.beans.factory.support.bean;

import org.example.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName UserDaoFactoryBean.java
 * @Description TODO
 * @createTime 2022/10/31
 */
public class UserDaoFactoryBean implements FactoryBean<IUserDao> {
    @Override
    public IUserDao getObject() throws Exception {
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if ("toString".equals(method.getName())) return this.toString();

                Map<String, String> hashMap = new HashMap<>();
                hashMap.put("10001", "xiaoMing");
                hashMap.put("10002", "xiaoHong");
                hashMap.put("10003", "daZhuang");

                String s = "你被代理了 " + method.getName() + "：" + hashMap.get(args[0].toString());
                return s;
            }
        };
        return (IUserDao) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{IUserDao.class}, handler);
    }

    @Override
    public Class<?> getObjectType() {
        return IUserDao.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
