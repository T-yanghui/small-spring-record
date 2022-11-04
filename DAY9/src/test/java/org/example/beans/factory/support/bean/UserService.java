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
public class UserService {
    private String uId;
    private String company;
    private String location;
    private IUserDao userDao;

    public String queryName(){
        return this.userDao.queryUserName(this.uId);
    }
    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

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

    public IUserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }
}
