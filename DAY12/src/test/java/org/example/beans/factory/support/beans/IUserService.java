package org.example.beans.factory.support.beans;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName IUserService.java
 * @Description TODO
 * @createTime 2022/11/08
 */
public interface IUserService {
    String queryUserInfo();

    String register(String userName);

}
