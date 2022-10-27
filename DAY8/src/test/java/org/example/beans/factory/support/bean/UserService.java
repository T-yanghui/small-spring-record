package org.example.beans.factory.support.bean;

import org.example.beans.BeansException;
import org.example.beans.factory.BeanClassLoaderAware;
import org.example.beans.factory.BeanFactory;
import org.example.beans.factory.BeanFactoryAware;
import org.example.beans.factory.BeanNameAware;
import org.example.context.ApplicationContext;
import org.example.context.ApplicationContextAware;
import org.junit.BeforeClass;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName UserService.java
 * @Description TODO
 * @createTime 2022/10/13
 */
public class UserService implements BeanNameAware, BeanFactoryAware, BeanClassLoaderAware , ApplicationContextAware {
    private String uId;
    private String company;
    private String location;
    private String beanName;
    private BeanFactory beanFactory;
    private ClassLoader classLoader;
    private ApplicationContext applicationContext;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    private UserDao userDao;

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public String queryUserInfo() {
        return userDao.queryUserName(uId);
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.classLoader=classLoader;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory=beanFactory;
    }

    public String getBeanName() {
        return beanName;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public ClassLoader getClassLoader() {
        return classLoader;
    }

    @Override
    public void setBeanName(String beanName) {
        this.beanName=beanName;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }
}
