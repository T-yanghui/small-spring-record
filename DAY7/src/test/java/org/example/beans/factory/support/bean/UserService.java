package org.example.beans.factory.support.bean;

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
}
