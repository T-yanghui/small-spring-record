package org.example.test.bean;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName IUserService.java
 * @Description TODO
 * @createTime 2023/03/25
 */
public interface IUserService {
    String queryUserInfo();
    String register(String userName);
}
